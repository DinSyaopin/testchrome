import Controller.Controller;
import Model.TestChromeActions;
import View.MainView;

public class ChromeTestApp {

    public static void main(String[] args) {
        // TODO add javadoc?
        // TODO add reading info from log file to the textarea?
        // TODO fix no error message if close window immediately
        // TODO Chrome not reachable after first start of test. Need to find a trouble.
        MainView view = new MainView();
        TestChromeActions testChromeActions = new TestChromeActions();
        Controller controller = new Controller(view, testChromeActions);
        controller.initController();
    }
}