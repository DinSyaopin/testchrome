package Model;

import Model.parsefile.Command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides transferring current comand from test scenary to
 * appropriate method in class ActionRepository.
 */
public class CommandListener {

    private static final Map<String, Method> actions = new HashMap<>();
    private static final ActionRepository actionRepository = new ActionRepository();

    static {
        for (Method m : actionRepository.getClass().getDeclaredMethods()) {
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
        String desc = command.getDescription();
        Method method = actions.get(action);

        Action act = method.getAnnotation(Action.class);
        method.invoke(actionRepository, params, desc);
    }

    public void quit() {
        actionRepository.quit();
    }
}
