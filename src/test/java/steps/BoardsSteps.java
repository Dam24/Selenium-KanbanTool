package steps;

import cucumber.api.java.en.Given;
import ui.PageTransporter;
import ui.pages.MainPage;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/12/15
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardsSteps {
    private MainPage mainPage;

    @Given("^I navigate to Dashboard page$")
    public void navigateDashboardPage(){
        mainPage=PageTransporter.getInstance().navigateToMainPage();
    }



}
