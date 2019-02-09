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

    private Map<String, Method> actions = new HashMap<>();
    private ActionRepository repository;

    public void bindAnnotationToMethod() {

        for (Method m : repository.getClass().getDeclaredMethods()) {
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

    public void onCommandReceived(Command command) {

        String action = command.getAction().toLowerCase();
        Method method = actions.get(action);
        try {
            method.invoke(repository, command.getParams(), command.getDescription());
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NullPointerException e) {
            repository.getWebDriver().quit();
            e.printStackTrace();
        }
    }

    public void quit() {
        repository.quit();
    }

    public void setRepository(ActionRepository repository) {
        this.repository = repository;
    }


}
