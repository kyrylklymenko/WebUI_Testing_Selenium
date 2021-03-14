package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.InsightsPage;
import pages.MainPage;
import pages.ApplicationPage;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;
    public MainPage mainPage;
    public ApplicationPage applicationPage;
    public InsightsPage insightsPage;
    public ContactUsPage contactUsPage;

    @BeforeEach
    public void start(){
        System.setProperty("webdriver.chrome.driver", "E:\\QA_Labs\\QA_AutoTesting\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        applicationPage = PageFactory.initElements(driver, ApplicationPage.class);
        insightsPage = PageFactory.initElements(driver, InsightsPage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @AfterEach
    public void finish(){

        driver.quit();
    }

}
