package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    protected HomePage _homePage;
    protected WebDriverWait wait;

    @BeforeSuite
    public void invokeBrowser() {
        //Get test data
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        //Set browser and driver
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser specified");
        }

        //browser properties
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Get url
        driver.get(configReader.getUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        _homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }









//    private DriverFactory driverFactory;
//    private WebDriver driver;
//    private ConfigReader configReader;
//    Properties prop;
//    protected HomePage _homePage;
//
//    @BeforeClass
//    public void getProperty() throws IOException {
//        configReader = new ConfigReader();
//        prop = configReader.init_prop();
//    }
//
//    @BeforeClass
//    public void launchBrowser() {
//        String browserName = prop.getProperty("browser");
//        driverFactory = new DriverFactory();
//        driver = driverFactory.setDriver(browserName);
//
//        //_homePage = new HomePage(driver);
//    }
//
//    @AfterClass
//    public void quitBrowser() {
//        driver.quit();
//    }
}
