package Controller;

import Model.TestChromeActions;
import View.MainView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Controller{
    private File file;

    private MainView view;
    private TestChromeActions testChromeActions;
    private String webDriverFileName;

    public Controller(MainView view, TestChromeActions testChromeActions) {
        this.view = view;
        this.testChromeActions = testChromeActions;
    }

    public void initController() {

        view.getFindFileButton().addActionListener(e -> findFile());
        view.getFindDriverNameButton().addActionListener(e -> findDriverName());

        view.getTestButton().addActionListener(e -> {
            try {
                if (file != null) {
                    runTestChromeActions(file, webDriverFileName);

                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "No file selected!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        view.getCloseItem().addActionListener(e -> {
            System.exit(0);
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
        }
        webDriverFileName = file.getAbsolutePath();
    }

    private void findFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choose = fileChooser.showDialog(null, "Choose file");
        if (choose == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }
    private void runTestChromeActions(File file, String webDriverFileName) throws Exception {
        TestChromeActions.start(file, webDriverFileName);
    }

}
