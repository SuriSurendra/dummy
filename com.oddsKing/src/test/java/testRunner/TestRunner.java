package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

@CucumberOptions(
        features = "src/test/features",
        glue = "src/test/stepDefinitions/RegistrationSteps",
        dryRun = true,
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
