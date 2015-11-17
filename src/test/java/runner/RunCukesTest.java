package runner;


import common.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;


/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/11/15
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class RunCukesTest  extends AbstractTestNGCucumberTests {

    @AfterTest
    public void afterExecution() {
        try {
            CommonMethods.logOut();
        } catch (Exception e) {
//            log.error("Unable to logout after execution", e);
        } finally {
            DriverManager.getInstance().Close();
        }
    }

}
