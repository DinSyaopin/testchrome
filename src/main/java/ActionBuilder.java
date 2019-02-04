import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ActionBuilder {

    //String value;
    private WebDriver driver;
    {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
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
        String predicate = arg.substring(0, arg.indexOf('|') - 1);
        String enteredText = arg.substring(arg.indexOf('|') + 1);
        WebElement element = driver.findElement(By.xpath(predicate));
        element.sendKeys(enteredText);
    }

    @Action(action = "screenshot", arg = "", aliases = "screen")
    void doScreenshot(String arg) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //should think about correct naming of screenshot
        //or move it to the tree of folders...
        Random random = new Random();
        int rand = random.nextInt(10000);
        FileUtils.copyFile(srcFile, new File("C:\\screenshot" + rand + ".png"));

    }
    public void quit() {
        driver.quit();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
