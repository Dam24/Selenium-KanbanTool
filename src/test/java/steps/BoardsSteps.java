package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.pages.BoardPage;
import ui.pages.DashBoardPage;
import ui.pages.MainPage;
import ui.pages.NewBoardPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    private BoardPage boardPage;

    @Given("^I navigate to Dashboard page$")
    public void navigateDashboardPage(){
        dashBoardPage=PageTransporter.getInstance().navigateToMainPage();
    }

    @When("I create a new board with the following details: Board Name: \"(.*?)\", description: \"(.*?)\", template: \"(.*?)\"")
    public void createNewBoard(String boardName, String boardDescription, String boardTemplate){
        newBoardPage= dashBoardPage.clickCreateNewBoardLink();
        dashBoardPage= newBoardPage.setCreateNewBoard(boardName,boardDescription,boardTemplate);
    }

    @Then("the Board \"(.*?)\" it should be displayed on the window")
    public void the_Board_it_should_be_displayed_on_the_window(){
        assertTrue(boardPage.isBoardPresent());
    }
    @And("I should view the Board name \"(.*?)\" in the boards list")
    public void view_the_Board_name_in_the_boards_list(String boardName){


    }



}
