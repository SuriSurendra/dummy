package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    //By locators
    private WebDriver _driver;
    private By phoneNumberField = By.id("RegistrationPage.TelephoneNumberInput.telephone.mobile-telephone");
    private By questionField = By.id("RegistrationPage.Dropdown.mobile-securityQuestion");
    private By answerField = By.id("RegistrationPage.ContactSection.mobile_security_answer");
    private By continueButton = By.xpath("//button[@class='_nljctal']");

    public ContactPage(WebDriver driver) {
        _driver = driver;
    }

    public void enterPhoneNumber(String phoneNumber) {
        _driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void selectSecurityQuestion(String value) {
        Select question = new Select(_driver.findElement(questionField));
        question.selectByValue(value);
    }

    public void enterSecurityAnswer(String answer) {
        _driver.findElement(answerField).sendKeys(answer);
    }

    public AddressPage clickContinueButton() {
        _driver.findElement(continueButton).click();
        return new AddressPage(_driver);
    }

    public String getContactPageTitle() {
        return _driver.getTitle();
    }
}
