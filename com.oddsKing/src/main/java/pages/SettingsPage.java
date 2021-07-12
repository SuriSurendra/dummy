package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage {

    private WebDriver _driver;

    //By locators
    private By emailCheckBox = By.id("firstParty-email-checkbox");

    public SettingsPage(WebDriver driver) {
        _driver = driver;
    }

    public void clickEmailCheckBox() {
        WebElement emailChkBox = _driver.findElement(emailCheckBox);
        JavascriptExecutor js = (JavascriptExecutor) _driver;
        js.executeScript("arguments[0].click()", emailChkBox);
    }

    public String getSettingsPageTitle() {
        return _driver.getTitle();
    }
}
