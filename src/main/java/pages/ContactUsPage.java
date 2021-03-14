package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ContactUsPage extends BasePage {

    @FindBy(id = "_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone-error")
    private WebElement incorrectPhone;

    @FindBy(name = "user_phone")
    private WebElement phoneInput;

    public ContactUsPage(WebDriver driver){
        super(driver);
        BASE_URL +="about/who-we-are/contact";
    }

    public void open(){
        driver.get(BASE_URL);
        clickCookieButton();
    }


    public void inputPhone() {
        phoneInput.sendKeys("IncorrectInput");
    }


    public void checkSuccess() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(incorrectPhone);
        isElementVisible(elements);
    }
}
