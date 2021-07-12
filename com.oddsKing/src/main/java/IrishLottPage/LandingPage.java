package IrishLottPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utils.ConfigReader;

import java.time.LocalDate;
import java.util.List;

public class LandingPage extends HomePage{

    //By locators
    private ConfigReader configReader = new ConfigReader();
    private By irishLotto = By.xpath("//span[contains(text(),'Irish Lotto')]");
    private By resultElement = By.xpath("//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/a[1]");
    private By dateFrom = By.cssSelector("div._1kdww6z div._ulj5y7:nth-child(3) div._19nbk62 div._1mj35d0o.dynamic-scrollbars.site-scrollbars div._ojs7nk.inner-container div._w93se div._17k2eih:nth-child(2) div._1pazxvm div._sbhwlz9 > div._az6wh2");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void gotoIrishLottoPage() {
        _driver.get(configReader.getUrl());
        _driver.findElement(irishLotto).click();
    }

    public void clickResults() {
        _driver.findElement(resultElement).click();
    }

    public String getPageTitle() {
        return _driver.getTitle();
    }

    public void setDateFrom() {
        _driver.findElement(dateFrom).click();
        List<WebElement> columns = _driver.findElements(By.tagName("td"));
        LocalDate now = LocalDate.now().minusDays(7);
        columns.stream()
                .filter(element -> element.getText().equals(now.getDayOfMonth()))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
