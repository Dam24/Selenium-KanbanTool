package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
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
    private CloneBoardPage cloneBoardPage;
    private SharingBoardPage sharingBoardPage;
//    private BoardNavBarPage boardNavBarPage;

    @Given("^I navigate to Dashboard page$")
    public void navigateDashboardPage(){
        dashBoardPage=PageTransporter.getInstance().navigateToMainPage();
    }

    @When("I create a new board with the following details: Board Name: \"(.*?)\", description: \"(.*?)\", template: \"(.*?)\"")
    public void createNewBoard(String boardName, String boardDescription, String boardTemplate){
//        newBoardPage= dashBoardPage.clickCreateNewBoardLink();
//        boardPage= newBoardPage.setCreateNewBoard(boardName,boardDescription,boardTemplate);

        newBoardPage= dashBoardPage.clickCreateNewBoardLink();
        sharingBoardPage=newBoardPage.setCreateNewBoard(boardName,boardDescription,boardTemplate);
        boardPage= sharingBoardPage.setSharingBoard();




    }

    @Then("the Board \"(.*?)\" it should be displayed on the window")
    public void the_Board_it_should_be_displayed_on_the_window(String boardName){
        assertTrue(boardPage.isBoardPresent());
    }
    @And("I should view the Board name \"(.*?)\" in the boards list")
    public void view_the_Board_name_in_the_boards_list(String boardName) throws InterruptedException {
        dashBoardPage=PageTransporter.getInstance().navigateToMainPage();
//        dashBoardPage= boardPage.clickExitButton();
        assertTrue(dashBoardPage.isBoardDisplayedOnList(boardName));
    }

    @When("I delete the board \"(.*?)\"")
    public void delete_the_board(String boardName){
//        dashBoardPage=PageTransporter.getInstance().navigateToMainPage();
        dashBoardPage= boardPage.clickExitButton();
        dashBoardPage.setDeleteBoard(boardName);

    }

    @Then("the board \"(.*?)\" not should be displayed on Dashboard List")
    public void board_not_should_be_displayed_on_Dashboard_list(String boardName) throws InterruptedException {
        assertFalse(dashBoardPage.isBoardDisplayedOnList(boardName));

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

    @Then("the \"([^\"]*)\" task should be displayed on the \"([^\"]*)\" column")
    public void taskIsDisplayedOnTheColumn(String taskName, String columnName){
        assertTrue(boardPage.isTaskPresent(taskName, columnName));

    }

    @When("^I cloned the board \"([^\"]*)\" with the name \"([^\"]*)\"$")
    public void I_cloned_the_board(String boardName, String cloneBoardName) throws Throwable {
        dashBoardPage= boardPage.clickExitButton();
        cloneBoardPage=dashBoardPage.clickCloneBoard(boardName);
        dashBoardPage=cloneBoardPage.setCloneBoard(cloneBoardName);
    }

    @When("^I edited in the column \"([^\"]*)\" the Task name from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void I_edited_in_the_column_the_Task_name_from_to(String columnName, String taskName, String newTaskName) throws Throwable {

        taskPage=boardPage.clickEditTask(columnName, taskName);
        boardPage= taskPage.editTask(newTaskName);

        //boardPage.setEditTask(columnName,taskName,newTaskName);
    }


    @When("^I move the task \"([^\"]*)\" from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void I_move_the_task_from_to(String taskName, String columnName, String columnDestine) throws Throwable {
        boardPage.moveTask(taskName,columnName,columnDestine);
    }

//    @After (value=@Boards)
    @After("@createBoard")
    public void deleteBoard(String boardName){
//        dashBoardPage=PageTransporter.getInstance().navigateToMainPage();
//        dashBoardPage= boardPage.clickExitButton();
        dashBoardPage.setDeleteBoard(boardName);
    }
}
