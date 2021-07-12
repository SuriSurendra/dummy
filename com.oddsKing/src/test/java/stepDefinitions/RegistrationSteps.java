package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import tests.BaseTest;
import utils.ConfigReader;

public class RegistrationSteps extends BaseTest {

    private ConfigReader configReader = new ConfigReader();
    private AccountPage accountPage = new AccountPage(driver);
    private PersonalPage personalPage = new PersonalPage(driver);
    private ContactPage contactPage = new ContactPage(driver);
    private AddressPage addressPage = new AddressPage(driver);
    private SettingsPage settingsPage = new SettingsPage(driver);


    @Before
    public void setUp(){
        invokeBrowser();
    }

    @After
    public void endTest() {
        tearDown();
    }

    //Home page
    @Given("^I navigate to the home page$")
    public void i_navigate_to_the_home_page() {
        System.out.println("Home page launched");

    }

    @When("^I click on Join$")
    public void i_click_on_join() {
        _homePage.clickJoinButton("Join");
    }

    @Then("^I should be on the account page$")
    public void i_should_be_on_the_account_page() {
        String actualTitle = accountPage.getAccountPageTitle();
        Assert.assertTrue(actualTitle.contains("Opening an account"));
    }

    //Account page
    @When("^I enter email address$")
    public void i_enter_email_address() {
        accountPage.enterEmailAddress(configReader.getEmail());
    }

    @When("^I enter username$")
    public void i_enter_username() {
        accountPage.enterUserName(configReader.getUserName());
    }

    @When("^I enter password$")
    public void i_enter_password() {
        accountPage.enterPassword(configReader.getPassword());
    }

    @When("^I click on Terms and Conditions checkbox$")
    public void i_click_on_Terms_and_Conditions_checkbox() {
        accountPage.clickTermsAndConditionsCheckBox();
    }

    @When("^I click Continue$")
    public void i_click_Continue() {
        accountPage.clickContinue();
    }

    @Then("^I should be redirected to Personal page$")
    public void i_should_be_redirected_to_Personal_page()  {
        String actualTitle = personalPage.getTextOnPage();
        Assert.assertTrue(actualTitle.contains("Your information"));
    }

    //Personal page
    @When("^I select title$")
    public void i_select_title() {
        personalPage.selectTitle();
    }

    @When("^I enter first name$")
    public void i_enter_first_name() {
        personalPage.enterFirstName(configReader.getFirsName());
    }

    @When("^I enter last name$")
    public void i_enter_last_name()  {
        personalPage.enterLastName(configReader.getLastName());
    }

    @When("^I enter date of birth$")
    public void i_enter_date_of_birth() throws Throwable {
        personalPage.enterDateOfBirth(configReader.getBirthDay(), configReader.getBirthMonth(),
                configReader.getBirthYear());
    }

    @Then("^I should be redirected to Contact page$")
    public void i_should_be_redirected_to_Contact_page() throws Throwable {
        String actualTitle = contactPage.getContactPageTitle();
        Assert.assertTrue(actualTitle.contains(""));
    }

    //Contact page
    @When("^I enter phone number$")
    public void i_enter_phone_number() {
        contactPage.enterPhoneNumber(configReader.getPhoneNumber());
    }

    @When("^I select a security question$")
    public void i_select_a_security_question() {
        contactPage.selectSecurityQuestion(configReader.getSecurityQuestion());
    }

    @When("^I enter an answer$")
    public void i_enter_an_answer() {
        contactPage.enterSecurityAnswer(configReader.getSecurityAnswer());
    }

    @When("^I click on Continue$")
    public void i_click_on_Continue()  {
        contactPage.clickContinueButton();
    }

    @Then("^I should be directed to Address page$")
    public void i_should_be_directed_to_Address_page() {
        String actualPageTitle = addressPage.getTextOnPage();
        Assert.assertTrue(actualPageTitle.contains("Due to gambling"));
    }

    //Address page
    @When("^I enter address or postcode$")
    public void i_enter_address_or_postcode() throws Throwable {
        addressPage.enterAddress(configReader.getAddress());
    }

    @Then("^I should be redirected to Settings page$")
    public void i_should_be_redirected_to_Settings_page() {
        addressPage.clickContinueButton();
    }

    //Settings page
    @When("^I click on email checkbox$")
    public void i_click_on_email_checkbox() throws Throwable {
        settingsPage.clickEmailCheckBox();
    }

    @Then("^I should see a greeting message for successful registration$")
    public void i_should_see_a_greeting_message_for_successful_registration() throws Throwable {
    }
}
