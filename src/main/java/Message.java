import java.util.Map;

public class Message {
    String action;
    String arg;

    public Message(Map.Entry<String, String> command) {
        this.action = command.getKey();
        this.arg = command.getValue();
    }

    public Message(String action, String arg) {
        this.action = action;
        this.arg = arg;
    }
}
