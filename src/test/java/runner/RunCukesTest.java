package runner;

import common.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
//        features = {"src/test/resources/features/filebroker/ingest.feature"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");

    @AfterTest
    public void afterExecution() {
        try {
            CommonMethods.logOut();
        } catch (Exception e) {
            log.error("Unable to logout after execution", e);
        } finally {
            DriverManager.getInstance().Close();
        }
    }
}