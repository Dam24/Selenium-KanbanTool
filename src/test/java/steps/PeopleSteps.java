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
 * Created by peniel on 16/11/2015.
 */
public class PeopleSteps {
    private LoginPage loginPage;
    private MainPage mainPage;
    private UsersPage usersPage;
    private UsersNewPage usersNewPage;
    private UsersSuspendedPage usersSuspendedPage;


    @Given("^I navigate to User page$")
    public void I_navigate_to_User_page() {
        usersPage = PageTransporter.getInstance().navigateToUsersPage();

    }

    @When("^I added a person with the following details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void I_added_a_person_with_the_following_details_(String userName, String userEmail, String checkBox) {
        usersNewPage=usersPage.clickAddBtn();
        usersPage=usersNewPage.addNewUserSuccessful(userName,userEmail,checkBox);
        //usersNewPage.addNewUserSuccessful(userName,userEmail,checkBox);
    }

    @Then("^the person \"([^\"]*)\" added should de displayed on the page$")
    public void the_person_added_should_de_displayed_on_the_page(String userName) throws InterruptedException {
        //////assertTrue(usersPage.findUserOnList(userName));
        //assertTrue(usersPage.isUserDisplayedInList(userName), "User" + userName + " displayed in List");
        assertTrue(usersPage.isUserDisplayedInList(userName));
        //assertEquals(userName,usersPage.isAddedUser(userName));

        //assertTrue(usersPage);
    }
    @And("A successful message: \"([^\"]*)\" should be displayed on the window")
    public void successful_Message_is_displayed_on_the_window(String message){
        assertEquals(message, usersPage.getCreatedUserMessage());
    }
//    @And("^I have 3 Users added$")
//    public void I_have_3_Users_added(){
//        usersPage=usersNewPage.addNewUserSuccessful(userName,userEmail,checkBox);
//
//    }
    @When("^I suspend to user \"([^\"]*)\"$")
    public void I_suspend_to_user(String userName) throws InterruptedException {
        //usersPage.setSuspendedUsers(userName);
        usersPage.clickSuspendUserBtn(userName);
//        usersPage.isAlertPresent();
    }
    @Then("The message \"([^\"]*)\" should be displayed on the window")
    public void suspendedUserMessage(String message){


        //usersPage.isSuspendedMessageDisplayed();
        assertEquals(message, usersPage.getSuspendedMessage());
    }

    @And("^I should not able to view to suspended user \"([^\"]*)\" on the Users list$")
    public void I_should_not_able_to_view_to_suspended_user_on_the_Users_list(String userName) throws InterruptedException {
        //assertFalse(usersPage.findUserOnList(userName));
        //System.out.println("state: " +usersPage.isUserDisplayedInList(userName));
        assertFalse(usersPage.isUserDisplayedInList(userName));
    }

    @And("^I should be able view the user suspended \"([^\"]*)\" on the suspended user list$")
    public void I_should_be_able_view_the_user_suspended_on_the_suspended_user_list(String userName){
        usersPage.clickSuspendUsers();
        assertTrue(usersSuspendedPage.isAddedSuspendedUser(userName));
    }

    @And("^I navigate to Suspended User List$")
    public void I_navigate_to_Suspended_User_List(){
        usersPage.clickSuspendUsers();
        //usersSuspendedPage=PageTransporter.getInstance().navigateToUserSuspendedPage();
    }

    @When("^I reactive to user \"([^\"]*)\"$")
    public void I_reactive_to_user(String userName){
        usersSuspendedPage.clickReactivateUserBtn(userName);
        //usersSuspendedPage.reactivateUser(userName);
    }
    @Then("^I should be able to view the message: There are no suspended users$")
    public void successfulMessage(){
        assertTrue(usersSuspendedPage.isMessageDisplayed());
    }
    @And("^I should be able to view to reactive user on Users lis$")
    public void I_should_be_able_to_view_to_reactive_user_on_Users_lis(String userName) throws InterruptedException {
        assertTrue(usersPage.isUserDisplayedInList(userName));
        //assertTrue(usersPage.isAddedUser(userName));
    }

}
