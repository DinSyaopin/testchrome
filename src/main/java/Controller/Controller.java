package Controller;

import Model.TestChromeActions;
import View.MainView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Controller{
    File file;

    private MainView view;
    private TestChromeActions testChromeActions;

    public Controller(MainView view, TestChromeActions testChromeActions) {
        this.view = view;
        this.testChromeActions = testChromeActions;
    }

    public void initController() {

        view.getFindFileButton().addActionListener(e -> findFile());

        view.getTestButton().addActionListener(e -> {
            try {
                if (file != null) {
                    runTestChromeActions(file);

                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "No file selected!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        view.getCloseItem().addActionListener(e -> {
            TestChromeActions.stop();
            System.exit(0);
        });

        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TestChromeActions.stop();
                System.exit(0);
            }
        });
    }

    private void findFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choose = fileChooser.showDialog(null, "Choose file");
        if (choose == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }
    private void runTestChromeActions(File file) throws Exception {
        TestChromeActions.start(file);
    }

}
