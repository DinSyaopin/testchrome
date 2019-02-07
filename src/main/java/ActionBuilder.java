import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionBuilder {

    private static final Logger logger = LogManager.getLogger(ActionBuilder.class);


    private WebDriver webDriver;

    {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    @Action(action = "openurl", arg = "", aliases = {"openSite, openURL"})
    void openurl(String arg) {
        try {
            logger.info("Try to open url: " + arg);
            webDriver.get(arg);
            logger.info(arg + " was opened");
        } catch (WebDriverException ex) {
            logger.error(ex.getCause());
            quit();
        }

    }

    @Action(action = "click", arg = "", aliases = "")
    void click(String arg) {
        try {
            logger.info("Try to click element by xpath: " + arg);
            WebElement element = webDriver.findElement(By.xpath(arg));
            logger.info(element + " was found");
            element.click();
            logger.info(element + " was clicked");
        }  catch (InvalidSelectorException ex) {
            logger.error(ex.getMessage());
            quit();
        }  catch (NoSuchElementException ex) {
            logger.error(ex.getMessage());
            quit();
        }  catch (WebDriverException ex) {
            logger.error(ex.getMessage());
            quit();
        }
    }

    @Action(action = "setvalue", arg = "", aliases = "set")
    void setValueInField(String arg) {
        try {
            logger.info("Try to set value to the field by xpath: " + arg);
            String predicate = arg.substring(0, arg.indexOf('|') - 1);
            String enteredText = arg.substring(arg.indexOf('|') + 1);
            WebElement element = webDriver.findElement(By.xpath(predicate));
            logger.info(element + " was found");
            element.sendKeys(enteredText);
            logger.info("Text: \"" + enteredText + "\" was printed to input field");
        } catch (InvalidSelectorException ex) {
            logger.error(ex.getMessage());
            quit();
        }  catch (NoSuchElementException ex) {
            logger.error(ex.getMessage());
            quit();
        }  catch (WebDriverException ex) {
            logger.error(ex.getMessage());
            quit();
        }
    }

    @Action(action = "screenshot", arg = "", aliases = "screen")
    void doScreenshot(String arg){
        try {
            logger.info("Try to take screenshot from browser's window");
            File srcFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            logger.info("Screenshot was created. Try to save it to filesystem");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
            String pathName = "screen" + dateFormat.format(new Date()) + ".png";
            FileUtils.copyFile(srcFile, new File(pathName));
            logger.info("Screenshot was saved");
        } catch (WebDriverException | IOException ex) {
            logger.error(ex.getMessage());
            quit();
        }
    }

    void quit() {
        webDriver.quit();
    }
}
