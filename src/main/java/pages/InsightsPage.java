package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InsightsPage extends BasePage {

    public InsightsPage(WebDriver driver){
        super(driver);
        BASE_URL +="insights";
    }



    public void open(){
        driver.get(BASE_URL);
        clickCookieButton();
    }





}
