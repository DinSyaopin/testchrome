import java.io.*;
import java.util.Map;

public class TestChromeActions {

    public static void start(File file) throws Exception {

        Map<String, String> scenary = FileExtensionFactory.makeScenaryFrom(file);

        CommandListener commandListener = new CommandListener();

        for (Map.Entry<String, String> command:
             scenary.entrySet()) {
            Message message = new Message(command);
            commandListener.onMessageReceived(message);
            Thread.sleep(500);
        }

        commandListener.quit();
    }
}
