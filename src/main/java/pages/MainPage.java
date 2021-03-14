package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'cookie-disclaimer__column')]")
    private List<WebElement> cookieWindow;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/footer/div/div[1]/ul/li[2]/a/img")
    private WebElement telescopeIcon;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[2]/div/div/footer/div/div[2]/ul[2]/li[2]")
    private WebElement twitterLogo;

    private String URL = "https://www.epam.com";

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(URL);
    }



    public void checkCookieWindowDisappeared()
    {
        assertFalse(cookieWindow.size() > 0);
    }

    public void clickTelescopeFooter() throws InterruptedException {
        telescopeIcon.click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        checkRedirectPage(driver.getCurrentUrl());
    }

    public void clickTwitterLogo() {
        twitterLogo.click();
    }


}
