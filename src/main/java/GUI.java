import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class GUI {

    private static File file;

    public static void main(String[] args) {
        // TODO add javadoc?
        // TODO add reading info from log file to the textarea?
        // TODO fix no error message if close window immediately
        // TODO Chrome not reachable after first start of test. Need to find a trouble.

        JFrame frame = new JFrame("Test Chrome Actions");
        Window window = new Window(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem close = new JMenuItem("Close");
        //JMenu menu1 = new JMenu("Help");
        //JMenuItem item = new JMenuItem("Open");
        //JMenuItem item1 = new JMenuItem("Save as");
        //menu.add(item);
        //menu.add(item1);
        menu.add(close);
        menuBar.add(menu);
        //menuBar.add(menu1);

        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea("Log:");
        textArea.setRows(18);
        JButton findFile = new JButton("Find file");
        JButton test = new JButton("Test");
        panel.add(findFile);
        panel.add(test);

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.getContentPane().add(BorderLayout.PAGE_END, panel);

        frame.setVisible(true);

        //Listeners part
        findFile.addActionListener(e -> findFile());
        close.addActionListener(e -> {
            TestChromeActions.stop();
            System.exit(0);
        });

        test.addActionListener(e -> {
            try {
                if (file != null) {
                    runTestChromeActions(file);

                } else {
                    JOptionPane.showMessageDialog(frame, "No file selected!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TestChromeActions.stop();
                System.exit(0);
            }
        });
    }

    private static void findFile() {
        JFileChooser fileChooser = new JFileChooser();
        int choose = fileChooser.showDialog(null, "Choose file");
        if (choose == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
    }

    private static void runTestChromeActions(File file) throws Exception {
        TestChromeActions.start(file);
    }
}
