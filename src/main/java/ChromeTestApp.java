import Controller.Controller;
import View.MainView;

public class ChromeTestApp {

    public static void main(String[] args) {
        // TODO add reading info from log file to the textarea or create runtime handler?
        // TODO fix no error message if close window immediately
        MainView view = new MainView();
        Controller controller = new Controller(view);
        controller.initController();
    }
}