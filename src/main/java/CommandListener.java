import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandListener {

    private static final Map<String, Method> actions = new HashMap<>();
    private static final ActionBuilder actionBuilder = new ActionBuilder();

    static {
        for (Method m : actionBuilder.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Action.class)) {
                Action action = m.getAnnotation(Action.class);
                actions.put(action.action(), m);
                for (String s:
                     action.aliases()) {
                    actions.put(s, m);
                }
            }
        }
    }
    public void onMessageReceived(Message message) throws NullPointerException, IllegalAccessException, InvocationTargetException {
        String action = message.action.toLowerCase();
        String arg = message.arg;

        Method method = actions.get(action);
        if (method == null) System.out.println("Имя метода не найдено");

        Action act = method.getAnnotation(Action.class);
        method.invoke(actionBuilder, arg);
    }

    public void quit() {
        actionBuilder.quit();
    }
}
