package testmaster.selenium.tests;

import org.junit.jupiter.api.Test;
import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.GuestPage;
import testmaster.selenium.pages.HomePage;
import testmaster.selenium.pages.LoginPage;
import testmaster.selenium.pages.TrackListPage;

public class SpotifyTest extends Driver {

    GuestPage guestPage = new GuestPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    TrackListPage trackListPage = new TrackListPage(driver);




@Test
    public void newTrackList() {
    guestPage.closeCookies();
    guestPage.goToLoginPage();
    loginPage.signIn();
    homePage.createTrackList();
    trackListPage.goToHomePage();
    homePage.addSongsToTrackListFromTopGlobal();
}

}

