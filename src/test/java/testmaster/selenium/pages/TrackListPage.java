package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.methods.Methods;

public class TrackListPage extends Methods {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    By homePageBtn = By.xpath("//a[@aria-label='Ana sayfa']");
    public TrackListPage(WebDriver driver){}

    public void goToHomePage(){
        clickElement(homePageBtn);
    }
}
