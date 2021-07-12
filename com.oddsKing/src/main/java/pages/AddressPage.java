package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {

    //By locators
    private WebDriver _driver;
    private By addressSearchField = By.id("search");
    private By continueButton = By.xpath("//button[@class='_nljctal']");
    private By textOnPage = By.xpath("//h3[contains(text(),'Due to gambling regulations we need to verify your')]");

    public AddressPage(WebDriver driver) {
        _driver = driver;
    }

    public void enterAddress(String address) {
        WebElement addressField = _driver.findElement(addressSearchField);
        addressField.click();
        addressField.clear();
        addressField.sendKeys(address);
        addressField.sendKeys(Keys.ENTER);
    }

    public SettingsPage clickContinueButton() {
        _driver.findElement(continueButton).click();
        return new SettingsPage(_driver);
    }

    public String getTextOnPage() {
        return _driver.findElement(textOnPage).getText();
    }
}
