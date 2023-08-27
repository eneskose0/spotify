package testmaster.selenium.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.methods.Methods;

public class HomePage extends Methods {

    private static final Logger logger = LogManager.getLogger(Driver.class);

    By createTrackListOrFolder = By.cssSelector("button[aria-label='Çalma listesi veya klasör oluştur']");
    By newTrackList = By.xpath("//span[text()='Yeni bir çalma listesi oluştur']");
    By trackListTitle = By.cssSelector("h1.Type__TypeElement-sc-goli3j-0.dYGhLW");
    By topGlobalSongList = By.xpath("//div[text()='En Çok Dinlenen Şarkılar - Global']");
    By addToTrackList = By.xpath("//span[text()='Çalma listesine ekle']");
    By addYourTrackList = By.cssSelector("div[class='i8EjndRQjYlli0aLGYEm'] button[class='wC9sIed7pfp47wZbmU6m']");

    public HomePage(WebDriver driver) {
    }

    public void createTrackList() {
        clickElement(createTrackListOrFolder);
        clickElement(newTrackList);
        Assert.assertTrue(isElementVisible(trackListTitle));
    }

    public void addSongsToTrackListFromTopGlobal(){
        clickElement(topGlobalSongList);
       // List<WebElement> globalSongsList = new ArrayList<>();
        for (int i = 1; i < 5; i++){
            rightClick(By.xpath(String.format("(//div[@data-testid='tracklist-row']) [%d]", i)));
            hoverElement(addToTrackList);
            clickElement(addYourTrackList);
        }
    }
}
