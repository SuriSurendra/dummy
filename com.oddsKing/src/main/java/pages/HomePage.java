package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage  {

    protected WebDriver _driver;
    protected WebDriverWait _wait;
    private By joinButton = By.linkText("Join");

    public HomePage(WebDriver driver) {
        _driver = driver;
    }

    public AccountPage clickJoinButton(String linkTest) {
        WebElement btnJoin = _driver.findElement(joinButton);
        _wait.until(ExpectedConditions.visibilityOf(btnJoin));
        _driver.findElement(joinButton).click();
        return new AccountPage(_driver);
    }
}
