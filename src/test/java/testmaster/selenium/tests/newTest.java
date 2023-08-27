package testmaster.selenium.tests;

import testmaster.selenium.driver.Driver;
import testmaster.selenium.pages.GuestPage;
import testmaster.selenium.pages.LoginPage;

public class newTest extends Driver {
    GuestPage guestPage = new GuestPage(driver);
    LoginPage loginPage =  new LoginPage(driver);
}
