package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.PageTransporter;
import ui.pages.*;

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
    private TaskPage taskPage;
//    private BoardNavBarPage boardNavBarPage;

    @Given("^I navigate to Dashboard page$")
    public void navigateDashboardPage(){
        dashBoardPage=PageTransporter.getInstance().navigateToMainPage();
    }

    @When("I create a new board with the following details: Board Name: \"(.*?)\", description: \"(.*?)\", template: \"(.*?)\"")
    public void createNewBoard(String boardName, String boardDescription, String boardTemplate){
        newBoardPage= dashBoardPage.clickCreateNewBoardLink();
        boardPage= newBoardPage.setCreateNewBoard(boardName,boardDescription,boardTemplate);
    }

    @Then("the Board \"(.*?)\" it should be displayed on the window")
    public void the_Board_it_should_be_displayed_on_the_window(String boardName){
        assertTrue(boardPage.isBoardPresent());
    }
    @And("I should view the Board name \"(.*?)\" in the boards list")
    public void view_the_Board_name_in_the_boards_list(String boardName){
        dashBoardPage= boardPage.boardNavBarPage.clickExitButton();
        //assertTrue(dashBoardPage.isBoardDisplayedOnList(boardName));
    }

    @When("I delete the board \"(.*?)\"")
    public void delete_the_board(String boardName){

    }

    @Then("the board \"(.*?)\" not should be displayed on Dashboard List")
    public void board_not_should_be_displayed_on_Dashboard_list(String boardName){

    }

    @When("I rename the Board \"(.*?)\"")
    public void rename_the_Board(String boardName){

    }



    //task feature
    @When("I added a new task in the Column \"([^\"]*)\" with the following details: \"([^\"]*)\"")
    public void addNewTaskOnColumn(String columnName, String taskName) throws InterruptedException {
        System.out.println(columnName+";;;;;"+taskName);
        taskPage= boardPage.clickAddTask(columnName);
        boardPage= taskPage.SetNewTask(taskName);
    }

    @Then("the new \"([^\"]*)\" task should be displayed on the \"([^\"]*)\" column")
    public void taskIsDisplayedOnTheColumn(String taskName, String columnName){
        assertTrue(boardPage.isTaskPresent(taskName, columnName));

    }


    @When("I edited in the column \"([^\"]*)\\ the Task name from \"([^\"]*)\\ to \"([^\"]*)\\")
    public void editTask(String columnName, String taskName, String newTaskName){

    }






}
