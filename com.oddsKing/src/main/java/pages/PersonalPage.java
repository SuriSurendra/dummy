package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPage {

    private WebDriver _driver;

    //By locators
    private By textOnPage = By.cssSelector("p._t9k4zn");
    private By title = By.xpath("//button[@name='Mr']");
    private By firstNameField = By.id("RegistrationPage.PersonalSection.first_name");
    private By lastNameField = By.id("RegistrationPage.PersonalSection.last_name");
    private By dayDoB = By.id("RegistrationPage.DateOfBirthInput.day");
    private By monthDoB = By.xpath("//input[@data-actionable='RegistrationPage.DateOfBirthInput.month");
    private By yearDoB = By.cssSelector("input._papbkyk");
    private By continueButton = By.xpath("//button[@class='_nljctal']");

    public PersonalPage(WebDriver driver) {
        _driver = driver;
    }

    public void selectTitle() {
        _driver.findElement(title).click();
    }

    public void enterFirstName(String firstName) {
        _driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        _driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterDateOfBirth(String day, String month, String year) {
        _driver.findElement(dayDoB).sendKeys(day);
        _driver.findElement(monthDoB).sendKeys(month);
        _driver.findElement(yearDoB).sendKeys(year);
    }

    public String getTextOnPage() {
        return _driver.findElement(textOnPage).getText();
    }

    public ContactPage clickContinueButton() {
        _driver.findElement(continueButton).click();
        return new ContactPage(_driver);
    }
}
