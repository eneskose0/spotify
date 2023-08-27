package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.methods.Methods;

public class GuestPage extends Methods {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    By closeCookieBtn = By.xpath("(//button[@aria-label='Kapat'])[2]");
    By loginBtn = By.xpath("//span[text()='Oturum aç']");
    By loginMsg = By.cssSelector("div.sc-gswNZR.sc-hLBbgP.jjCFwq.GISjU h1");

    public GuestPage(WebDriver driver) {
    }

    public void closeCookies(){
        clickElement(closeCookieBtn);
        //çerezler kapatılır
    }

    public void goToLoginPage(){
        Assert.assertEquals("Oturum aç", findElement(loginBtn).getText());
        //guestpagede olduğu doğrulanır.
        clickElement(loginBtn);
        //Login sayfasına gidilir.
        Assert.assertEquals("Spotify'da oturum aç", getText(loginMsg));
        logger.info("Login sayfasinda oldugu dogrulandi");
    }
}
