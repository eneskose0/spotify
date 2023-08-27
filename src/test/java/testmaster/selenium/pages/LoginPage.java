package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.methods.Methods;

public class LoginPage extends Methods {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    By enterUserName = By.id("login-username");
    By enterPassword = By.id("login-password");
    By loginBtn = By.id("login-button");
    By library = By.xpath("//button[text()='Kitaplığın']");

    public LoginPage(WebDriver driver) {
    }

    public void signIn() {
        sendKeys(enterUserName, "esoksene@gmail.com");
        sendKeys(enterPassword, "i3AHyPMUn_?ta8a");
        clickElement(loginBtn);
        //kullanıcı adı ve şifre girilir, giriş yap butonuna basılır.
        Assert.assertEquals("Kitaplığın", getText(library));
        logger.info("Giris yapildi");
    }


}
