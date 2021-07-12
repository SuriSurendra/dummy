package stepDefinitions;

import IrishLottPage.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import tests.BaseTest;

public class IrishLottoSteps extends HomePage {


    public IrishLottoSteps(WebDriver driver) {
        super(driver);
    }

    LandingPage landingPage = new LandingPage(_driver);

    @Given("User is on Irish Lotto page")
    public void user_is_on_irish_lotto_page() {
        landingPage.gotoIrishLottoPage();
    }

    @When("User clicks on Result")
    public void user_clicks_on_result() {
        landingPage.clickResults();
    }

    @Then("User should be able to filter results by date")
    public void user_should_be_able_to_filter_results_by_date() {
        String actualTitle = landingPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Lotto Draws"));
    }
}
