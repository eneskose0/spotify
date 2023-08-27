package testmaster.selenium.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import testmaster.selenium.driver.Driver;

import java.time.Duration;

public class Methods {
    private static final Logger logger = LogManager.getLogger(Methods.class);
    WebDriver driver;
    //WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor js;

    public Methods() {
        this.driver = Driver.driver;
        js = (JavascriptExecutor) driver;
        fluentWait = setFluentWait(30);
    }
    public FluentWait<WebDriver> setFluentWait(long timeout){

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public WebElement findElementWait(By by) {
        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void clickElement(By by) {
        findElementWait(by).click();
    }

    public String getText(By by) {
        return findElementWait(by).getText();
    }

    public void sendKeys(By by, String text) {

        findElementWait(by).sendKeys(text);
    }

    public void rightClick(By by) {

        WebElement webElement = findElementWait(by);
        Actions actions = new Actions(driver);
        actions.contextClick(webElement).build().perform();
        logger.info(by.toString() + "elementine sağ tıklandı ");
    }

    public void hoverElement(By by) {

        WebElement webElement = findElementWait(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(by.toString() + "element hoverlandı.");
    }

    public boolean isElementVisible(By by) {
        try {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info(by.toString() + "element visible ");
            return true;
        } catch (Exception e) {
            logger.info(by.toString() + " element visible değil, false ");
            logger.error(e.getMessage());
            return false;
        }
    }

}
