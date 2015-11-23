package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.pages.DashBoardPage;
import ui.pages.MainPage;
import ui.pages.NewBoardPage;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/12/15
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class BoardsSteps {
    private MainPage mainPage;
    private DashBoardPage dashBoardPage;
    private NewBoardPage newBoardPage;

    @Given("^I navigate to Dashboard page$")
    public void navigateDashboardPage(){
        mainPage=PageTransporter.getInstance().navigateToMainPage();
    }

    @When("I create a new board with the following details: Board Name: \"(.*?)\", description: \"(.*?)\", template: \"(.*?)\"")
    public void createNewBoard(String boardName, String boardDescription, String boardTemplate){
        dashBoardPage.clickCreateNewBoardLink();
        newBoardPage.setCreateNewBoard(boardName,boardDescription,boardTemplate);
    }



}
