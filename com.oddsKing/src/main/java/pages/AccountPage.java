package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private WebDriver _driver;

    //By locators
    private By emailField = By.id("RegistrationPage.AccountSection.email");
    private By passwordField = By.id("RegistrationPage.AccountSection.password");
    private By userNameField = By.id("RegistrationPage.AccountSection.username");
    private By conditionsCheckBox = By.id("agree_terms-checkbox");
    private By continueButton = By.cssSelector("button._nljctal");

    public AccountPage(WebDriver driver) {
        _driver = driver;
    }

    public void enterEmailAddress(String email) {
        _driver.findElement(emailField).sendKeys(email);

    }

    public void enterUserName(String userName) {
        _driver.findElement(userNameField).sendKeys(userName);
    }

    public void enterPassword(String password) {
        _driver.findElement(passwordField).sendKeys(password);
    }

    public void clickTermsAndConditionsCheckBox() {
        WebElement termsCheckBox = _driver.findElement(conditionsCheckBox);
        if (!termsCheckBox.isSelected()) {
            JavascriptExecutor js = (JavascriptExecutor) _driver;
            js.executeScript("arguments[0].click()", termsCheckBox);
        }
    }

    public PersonalPage clickContinue() {
        _driver.findElement(continueButton).click();
        return new PersonalPage(_driver);
    }

    public String getAccountPageTitle(){
        return _driver.getTitle();
    }
}
