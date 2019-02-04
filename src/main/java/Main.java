import java.io.*;
import java.util.Map;

public class Main {
    private static File file = new File("src/test.txt");

    public static void main(String[] args) throws Exception {
        //read file
        //translate to appropriate parsing class through extesion
        //Extract Map scenary
        //foreach(map element from scenary)
        //action = map.get(0,0);
        //value = map.get(0,1);
        //do ActionListener
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = bufferedReader.readLine();
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
