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
 * Time            : 12:27 PM
 * Description     : This is the mixed class to simulate test passing, failing and skipping
 **/

public class MixedTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage(getDriver());
    }

    @Category("Passing category in MixedTest class")
    @Test(description = "Passing test simulation")
    public void testPassingMethod() {
        assertEquals(homePage.getProfileName(), "Osanda Deshan Nimalarathna");
    }

    @SuppressWarnings("TestFailedLine")
    @Category("Failing category in MixedTest class")
    @Test(description = "Failing test simulation")
    public void testFailingMethod1() {
        assertEquals(homePage.getProfileName(), "Osanda Deshan");
    }

    @SuppressWarnings("TestFailedLine2")
    @Category("Failing category in MixedTest class")
    @Test(description = "Failing test simulation")
    public void testFailingMethod2() {
        assertEquals(homePage.getInvalidLocator(), "");
    }

    @Category("Skipping category in MixedTest class")
    @Test(description = "Skipping test simulation", dependsOnMethods = "testFailingMethod1")
    public void testSkippingMethod() {
        System.out.println("'testSkippingMethod' method will skip");
    }
}
