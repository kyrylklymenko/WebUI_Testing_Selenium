package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class BasePage {

    @FindBy(xpath = "//*[contains(@class,'button-ui bg-color-light-blue cookie-disclaimer__button')]")
    private WebElement cookieButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/div/header/div/a/img")
    private WebElement mainLogo;

    @FindBy(xpath= "/html/body/div[2]/div[2]/div[1]/header/div/ul/li[2]/div/button")
    private WebElement locationDropdown;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/header/div/ul/li[2]/div/nav/ul/li[9]/a")
    private WebElement russianLocation;

    private final String headerPattern = "//a[@href='/%s']";

    private final String aboutPattern = "//a[@href='/about/%s']";

    protected String BASE_URL ="https://www.epam.com/";
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver,15);
    }

    public void clickMainLogo(){
        mainLogo.click();
    }

    public void isElementVisible(List<WebElement> elements){
        assertTrue(elements.size()>0);
    }



    public void clickCookieButton(){
        cookieButton.click();
    }

    public void checkRedirectPage(String url) throws InterruptedException {
        sleep(500);
        assertEquals(url, driver.getCurrentUrl());
    }


    public void chooseLocation() {
        locationDropdown.click();
        russianLocation.click();
    }

    public void clickHeaderSection(String section) {
        WebElement sectionButton = driver.findElement(By.xpath(String.format(headerPattern, section)));
        sectionButton.click();
    }

    public void dropdownAboutAndClick(String abtSection) {
        WebElement investorsButton = driver.findElement(By.xpath(String.format(aboutPattern, "investors")));
        investorsButton.click();
    }
}
