package steps;

import common.CommonMethods;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ui.PageTransporter;
import ui.pages.DashBoardPage;
import ui.pages.LoginPage;
import ui.pages.MainPage;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

//import static org.testng.Assert.assertTrue;
//import static org.testng.asserts.Assertion.*;
//import static org.testng.AssertJUnit.assertTrue;



/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/9/15
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginSteps {
    private LoginPage loginPage;
    private MainPage mainPage;
    private DashBoardPage dashboardPage;
    private CommonMethods commonMethods;

    //private PageTransporter pageTransporter=PageTransporter.getInstance();
  private WebDriver webDriver;
  //  private DriverManager driverManager;

    @Given("^I navigate to Login page$")
    public void navigateLoginPage(){
        loginPage=PageTransporter.getInstance().navigateToLoginPage();
    }
    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void login(String userName, String userPassword){
        //webDriver= driverManager.getWebDriver();
        mainPage = loginPage.loginSuccessful(userName, userPassword);
    }
    @Then("^I should login successfully$")
    public void verifyMainPageIsDisplayed() {
        //assertTrue(mainPage.isUserNameDisplayed(), "User name displayed");
        assertTrue(mainPage.isUserNameDisplayed());
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\" Incorrect$")
    public void loginFailed(String userName, String userPassword){
        loginPage=loginPage.loginFailed(userName,userPassword);
    }

    @Then ("^I not should login successfully$")
    public void verifyMainPageNotIsDisplayed(){
        assertTrue(loginPage.getErrorMessage());
        //assertEquals(loginPage.getErrorMessage(), "The username or password is invalid..");
    }

    //****************************************************************
    //Hooks for @LoginSteps scenarios
    //****************************************************************
    @After(value = "@LoginSteps", order = 999)
    public void afterLoginScenario() {
        commonMethods.logOut();
    }

    @When("^I logout$")
    public void I_logout() throws Throwable {
        loginPage= mainPage.logOut();
    }
}


