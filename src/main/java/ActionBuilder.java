import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ActionBuilder {

    private static final Logger LOGGER = LogManager.getLogger(ActionBuilder.class);


    private EventFiringWebDriver eventWebDriver;
    {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        eventWebDriver = new EventFiringWebDriver(new ChromeDriver());
        eventWebDriver.manage().window().maximize();
        eventWebDriver.manage().deleteAllCookies();
        eventWebDriver.register(new EventListener());
    }

    @Action(action = "openurl", arg = "", aliases = {"openSite, openURL"})
    void openurl(String arg) {
        eventWebDriver.get(arg);
    }

    @Action(action = "click", arg = "", aliases = "")
    void click(String arg) {
        try {
            WebElement element = eventWebDriver.findElement(By.xpath(arg));
            element.click();
        } catch (NoSuchElementException ex) {
            LOGGER.error("ABCD", ex);
        }
    }

    @Action(action = "setvalue", arg = "", aliases = "set")
    void setValueInField(String arg) {
        String predicate = arg.substring(0, arg.indexOf('|') - 1);
        String enteredText = arg.substring(arg.indexOf('|') + 1);
        WebElement element = eventWebDriver.findElement(By.xpath(predicate));
        element.sendKeys(enteredText);
    }

    @Action(action = "screenshot", arg = "", aliases = "screen")
    void doScreenshot(String arg) throws IOException {
        File srcFile = ((TakesScreenshot) eventWebDriver).getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int rand = random.nextInt(10000);
        FileUtils.copyFile(srcFile, new File("C:\\screenshot\\screenshot" + rand + ".png"));

    }
    void quit() {
        eventWebDriver.quit();
    }

    public void setEventWebDriver(EventFiringWebDriver eventWebDriver) {
        this.eventWebDriver = eventWebDriver;
    }
}
