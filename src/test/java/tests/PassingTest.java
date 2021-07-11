package tests;

import com.maxsoft.testngtestresultsanalyzer.annotations.Category;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static org.testng.Assert.assertEquals;

/**
 * Project Name    : maxsoft-test-results-analyzer-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/11/2021
 * Time            : 12:28 PM
 * Description     : This is the passing class to simulate test passing
 **/

public class PassingTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage(getDriver());
    }

    @Category("Passing category in PassingTest class")
    @Test(description = "Passing test simulation 1")
    public void testPassingMethod1() {
        assertEquals(homePage.getProfileName(), "Osanda Deshan Nimalarathna");
    }

    @Category("Passing category in PassingTest class")
    @Test(description = "Passing test simulation 2")
    public void testPassingMethod2() {
        assertEquals(homePage.getUsername(), "osandadeshan");
    }
}
