package Model;

import Model.parsefile.Command;

import java.io.*;
import java.util.ArrayList;

public class TestChromeActions {

    private static CommandListener commandListener;

    public static void start(File file) throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ArrayList<Command> scenary = FileExtensionFactory.makeScenaryFrom(file);

         commandListener = new CommandListener();

        for (Command command :
                scenary) {
            commandListener.onCommandReceived(command);
            Thread.sleep(1000);
        }
    }

    public static void stop() {
        if (commandListener != null) {
            commandListener.quit();
        }
    }
}
