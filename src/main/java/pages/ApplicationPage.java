package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ApplicationPage extends BasePage {

    @FindBy(id = "_content_epam_en_careers_job-listings_job_jcr_content_right-container_form_constructor_applicantFirstName")
    private WebElement nameField;

    @FindBy(id = "_content_epam_en_careers_job-listings_job_jcr_content_right-container_form_constructor_applicantLastName")
    private WebElement surnameField;

    @FindBy(id = "_content_epam_en_careers_job-listings_job_jcr_content_right-container_form_constructor_applicantEmail")
    private WebElement emailField;

    @FindBy(xpath = "//span[@class='validation-text' and text()='Incorrect email format']")
    private WebElement submitButton;

    @FindBy(className = "validation-text")
    private WebElement emailNotification;

    public ApplicationPage(WebDriver driver){
        super(driver);
        BASE_URL +="careers/job-listings/job.57246.big-data-support-engineer_mexico-city_mexico";
    }

    public void open(){
        driver.get(BASE_URL);
        clickCookieButton();
    }


    public void inputFields() {
        nameField.sendKeys("Just");
        surnameField.sendKeys("Testing");
        emailField.sendKeys("Incorrect");
    }


    public void checkSuccess() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(emailNotification);
        isElementVisible(elements);
    }
}
