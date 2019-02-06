import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener extends AbstractWebDriverEventListener {

    private static final Logger LOGGER = LogManager.getLogger(EventListener.class);

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        LOGGER.info("WebDriver navigated to " + s);
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.info("WebDriver click on element " + webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        LOGGER.info("Try to get screenshot. ");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        LOGGER.info("Have token screenshot. ");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
