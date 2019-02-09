package Controller;

import Model.ActionRepository;
import Model.CommandListener;
import Model.FileExtensionFactory;
import Model.parsefile.Command;
import View.MainView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller{
    private File file;

    private MainView view;
    private String webDriverFileName;

    public Controller(MainView view) {
        this.view = view;
    }

    public void initController() {

        view.getFindFileButton().addActionListener(e -> findFile());

        view.getFindDriverNameButton().addActionListener(e -> findDriverName());

        view.getTestButton().addActionListener(e -> {
            try {
                if (file != null && webDriverFileName != null) {
                    start();
                }
                else {
                    JOptionPane.showMessageDialog(view.getFrame(), "No file selected!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void findDriverName() {
        JFileChooser fileChooser = new JFileChooser();
        int choose = fileChooser.showDialog(null, "Choose file");
        if (choose == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            webDriverFileName = file.getAbsolutePath();
        }
    }

    private void findFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choose = fileChooser.showDialog(null, "Choose file");
        if (choose == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }

    private void start() throws Exception {

        ArrayList<Command> scenary = FileExtensionFactory.makeScenaryFrom(file);

        System.setProperty("webdriver.chrome.driver", webDriverFileName);

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();

        ActionRepository repository = new ActionRepository();

        repository.setWebDriver(webDriver);

        CommandListener commandListener = new CommandListener();
        commandListener.setRepository(repository);
        commandListener.bindAnnotationToMethod();

        for (Command command : scenary) commandListener.onCommandReceived(command);

        commandListener.quit();
    }
}
