import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ActionBuilder {

    //String value;
    private WebDriver driver;
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\temkinda\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Action(action = "openurl", arg = "", aliases = {"openSite, openURL"})
    void openurl(String arg) {
        driver.get(arg);
    }

    @Action(action = "click", arg = "", aliases = "")
    void click(String arg) {
        WebElement element = driver.findElement(By.xpath(arg));
        element.click();
    }

    @Action(action = "setvalue", arg = "", aliases = "set")
    void setValueInField(String arg) {
        //value as predicate + enterString
        //need to check split
        String predicate = arg.substring(0, arg.indexOf('|'));
        String enteredText = arg.substring(arg.indexOf('|') + 1);
        WebElement element = driver.findElement(By.xpath(predicate));
        element.sendKeys(enteredText);
    }

    @Action(action = "screenshot", arg = "", aliases = "screen")
    void doScreenshot() throws IOException {
        //without value
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //need to check
        FileWriter fileWriter = new FileWriter(scrFile);
    }
    public void quit() {
        driver.quit();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
