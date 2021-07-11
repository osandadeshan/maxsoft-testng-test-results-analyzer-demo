package tests;

import com.maxsoft.testngtestresultsanalyzer.ReportListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.setDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Project Name    : maxsoft-test-results-analyzer-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/11/2021
 * Time            : 12:18 PM
 * Description     : This is the base test class that used to extend in all other test classes
 **/

@Listeners(ReportListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(60, SECONDS);
        getDriver().get("https://github.com/osandadeshan/");
    }

    @AfterMethod
    public void closeBrowser() {
        if (getDriver() != null)
            getDriver().quit();
    }
}
