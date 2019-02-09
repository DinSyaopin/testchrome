import Controller.Controller;
import View.MainView;

public class ChromeTestApp {

    public static void main(String[] args) {

        MainView view = new MainView();
        Controller controller = new Controller(view);
        controller.initController();
    }
}