import Controller.Controller;
import Model.TestChromeActions;
import View.MainView;

public class ChromeTestApp {

    public static void main(String[] args) {
        // TODO add reading info from log file to the textarea or create runtime handler?
        // TODO fix no error message if close window immediately
        // TODO Chrome not reachable after first start of test. Need to find a trouble.
        MainView view = new MainView();
        TestChromeActions testChromeActions = new TestChromeActions();
        Controller controller = new Controller(view);
        controller.initController();
    }
}