import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI {

    private static File file;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Chrome Actions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu menu1 = new JMenu("Help");
        JMenuItem item = new JMenuItem("Open");
        JMenuItem item1 = new JMenuItem("Save as");
        menu.add(item);
        menu.add(item1);
        menuBar.add(menu);
        menuBar.add(menu1);

        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea("Log:");
        JButton findFile = new JButton("Find file");
        JButton test = new JButton("Test");
        panel.add(findFile);
        panel.add(test);

        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.PAGE_END, textArea);
        frame.getContentPane().add(BorderLayout.PAGE_END, panel);

        frame.setVisible(true);

        //Listeners part
        findFile.addActionListener(e -> findFile());

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
