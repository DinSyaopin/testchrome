import parsefile.Command;

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
    public void onCommandReceived(Command command) throws NullPointerException, IllegalAccessException, InvocationTargetException {
        String action = command.getAction().toLowerCase();
        String params = command.getParams();

        Method method = actions.get(action);
        if (method == null) System.out.println("Имя метода не найдено");

        Action act = method.getAnnotation(Action.class);
        method.invoke(actionBuilder, params);
    }

    public void quit() {
        actionBuilder.quit();
    }
}
