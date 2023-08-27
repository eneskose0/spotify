package testmaster.selenium.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);
    public static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        logger.info("BeforeAll");
    }
    @BeforeEach
    public void beforeEach(){
        logger.info("BeforeEach");
        System.setProperty("webdriver.chrome.driver","src/chromedriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("disable-infobars");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://open.spotify.com/");
    }
    @AfterEach
    public void afterEach(){
        logger.info("AfterEach");
    }
    @AfterAll
    public static void afterAll(){
        logger.info("AfterAll");
    }

}
