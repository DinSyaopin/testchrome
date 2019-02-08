package View;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem closeItem;
    private JButton findFileButton;
    private JButton testButton;
    private JPanel panel;
    private JButton findDriverNameButton;

    public MainView() {

        menuBar = new JMenuBar();
        menu = new JMenu("File");
        closeItem = new JMenuItem("Close");
        menu.add(closeItem);
        menuBar.add(menu);

        findDriverNameButton = new JButton("Find driver");
        findFileButton = new JButton("Find file");
        testButton = new JButton("Test");

        panel = new JPanel();
        panel.add(findDriverNameButton, BorderLayout.WEST);
        panel.add(findFileButton, BorderLayout.CENTER);
        panel.add(testButton, BorderLayout.EAST);

        frame = new JFrame("ChromeTestApp");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public JMenuItem getCloseItem() {
        return closeItem;
    }

    public void setCloseItem(JMenuItem closeItem) {
        this.closeItem = closeItem;
    }

    public JButton getFindFileButton() {
        return findFileButton;
    }

    public void setFindFileButton(JButton findFileButton) {
        this.findFileButton = findFileButton;
    }

    public JButton getTestButton() {
        return testButton;
    }

    public void setTestButton(JButton testButton) {
        this.testButton = testButton;
    }

    public JButton getFindDriverNameButton() {
        return findDriverNameButton;
    }

    public void setFindDriverNameButton(JButton findDriverNameButton) {
        this.findDriverNameButton = findDriverNameButton;
    }
}
