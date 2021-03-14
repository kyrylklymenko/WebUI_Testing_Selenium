import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.TestBase;

public class StepDefinitions extends TestBase {

    @Before
    public void init(){
        start();
    }

    @After
    public void quit(){
        finish();
    }

    @Given("user is at the main page for the first time")
    public void openMainPageWithCookies() {
        mainPage.open();
    }


    @Given("user is at the main page")
    public void openMainPage() {
        mainPage.open();
        mainPage.clickCookieButton();
    }

    @When("user clicks the accept cookie button")
    public void acceptCookies(){
        mainPage.clickCookieButton();
    }

    @Then("the cookie window is closed")
    public void checkCookieVanished(){
        mainPage.checkCookieWindowDisappeared();
    }

    @When("user clicks \"TELESCOPEAI\" button in the footer")
    public void clickTelescope() throws InterruptedException {
        mainPage.clickTelescopeFooter();
    }

    @Then("user gets redirected to TelescopeAI site: {string}")
    public void checkTelescopeRedirection(String url) throws InterruptedException {

        applicationPage.checkRedirectPage(url);
    }

    @Given("user is at the insights page")
    public void openInsights(){
        insightsPage.open();
    }

    @When("user clicks logo the top-left corner")
    public void clickTheMainLogo() {
        insightsPage.clickMainLogo();
    }

    @Then("user goes to the main page: {string}")
    public void iReturnToTheMainPage(String url) throws InterruptedException {
        mainPage.checkRedirectPage(url);
    }

    @When("user clicks twitter icon in the footer")
    public void user_clicks_twitter_icon_in_the_footer() {
        mainPage.clickTwitterLogo();
    }

    @Then("user gets redirected to {string}")
    public void user_gets_redirected_to(String url) throws InterruptedException {
        mainPage.checkRedirectPage(url);
    }

    @When("user clicks the drop down menu with languages in header and clicks Россия")
    public void chooseLocation(){
        mainPage.chooseLocation();
    }

    @When("user clicks the {string} button in the header of the site")
    public void clickHeaderSection(String section) {
        mainPage.clickHeaderSection(section);
    }

    @Given("user is at Big Data Support Engineer in Mexico-City Mexico vacation")
    public void openVacation(){
        applicationPage.open();
    }

    @When("user fills the email field incorrectly")
    public void fillAndSubmitVacation(){
        applicationPage.inputFields();
    }

    @Then("user is acknowledged about error")
    public void errorNotification() {
        applicationPage.checkSuccess();
    }

    @When("user hovers cursor at the drop down menu About clicks {string}")
    public void hoverDrowdownAndClick(String abtSection) {
        mainPage.dropdownAboutAndClick(abtSection);
    }

    @Given("user is at the contacts page")
    public void openContactUsPage() {
        contactUsPage.open();
    }

    @When("user fill the phone info incorrectly")
    public void fillPhoneIncorrectly() {
        contactUsPage.inputPhone();
    }

    @Then("UI shows the notification about the incorrect input")
    public void ui_shows_the_notification_about_the_incorrect_input() {
        contactUsPage.checkSuccess();
    }
}
