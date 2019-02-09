package Model;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class store itself methods for handling actions
 * from test files.
 */
public class ActionRepository {

    private static final Logger logger = LogManager.getLogger(ActionRepository.class);

    private WebDriver webDriver;

    @Action(action = "openurl", params = "", desc = "", aliases = {"openSite, openURL"})
    void openUrl(String params, String desc) {
        try {
            if (desc == null) {
                logger.info("Try to open a site");
            } else logger.info(desc + " " + params);
            webDriver.get(params);
            logger.info(params + " was opened");
        } catch (WebDriverException ex) {
            logger.error(ex.getMessage());
            quit();
        }
    }

    @Action(action = "click", params = "", desc = "", aliases = "")
    void click(String params, String desc) {
        try {
            if (desc == null) {
                logger.info("Try to click element");
            } else logger.info(desc + " " + params);
            WebElement element = webDriver.findElement(By.xpath(params));
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

    @Action(action = "setvalue", params = "", desc = "", aliases = "set")
    void setValueInField(String params, String desc) {
        try {
            if (desc == null) {
                logger.info("Try to set value to the text field");
            } else logger.info(desc + " " + params);

            String predicate = params.substring(0, params.indexOf('|') - 1);
            String enteredText = params.substring(params.indexOf('|') + 2);
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

    @Action(action = "screenshot", params = "", desc = "", aliases = "screen")
    void doScreenshot(String params, String desc){
        try {
            if (desc == null) {
                logger.info("Try to take screenshot");
            } else logger.info(desc);
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

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
