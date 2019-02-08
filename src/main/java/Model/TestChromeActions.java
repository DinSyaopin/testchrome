package Model;

import Model.parsefile.Command;

import java.io.*;
import java.util.ArrayList;

public class TestChromeActions {

    public static void start(File file, String webDriverFileName) throws Exception {

        System.setProperty("webdriver.chrome.driver", webDriverFileName);

        ArrayList<Command> scenary = FileExtensionFactory.makeScenaryFrom(file);

         CommandListener commandListener = new CommandListener();

        for (Command command :
                scenary) {
            commandListener.onCommandReceived(command);
            Thread.sleep(1000);
        }
        commandListener.quit();
    }
}