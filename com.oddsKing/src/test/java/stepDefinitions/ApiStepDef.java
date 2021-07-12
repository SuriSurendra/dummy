package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.ResponseBody;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApiStepDef {

    WebDriver driver;
   String url= "http://affiliate-feed.petfre.sgp.bet/1/health";
    public Properties prop = new Properties();
    public FileInputStream ip= new FileInputStream("src/main/resource/config/config.properties");

    public ApiStepDef() throws FileNotFoundException {
    }





    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }



    @Then("user should validate the response")

    public void getApiTet(String url)
        {
            Response resp= RestAssured.given().when().get(url);
            ResponseBody body= resp.getBody();
            String bodyasstring= body.asString();
            Assert.assertEquals(bodyasstring.contains("OK"), true);

        }

    @And("user close the browser")
    public void userCloseTheBrowser() {
        driver.quit();
    }

    @And("I should add <language> as a parameter")
    public void iShouldAddLanguageAsAParameter(String url) throws IOException {

        prop.load(ip);

        given().
                when().
                get(url+"en")
                .then().log().body();

        System.out.println("Case Executed.");

    }

    @Then("user should validate the countries retrieved")
    public void userShouldValidateTheCountriesRetrieved() {



    }
}
}
