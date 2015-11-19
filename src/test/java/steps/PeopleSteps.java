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
    public void the_person_added_should_de_displayed_on_the_page(String userName) {
        //////assertTrue(usersPage.findUserOnList(userName));
        //assertTrue(usersPage.isUserDisplayedInList(userName), "User" + userName + " displayed in List");
        assertTrue(usersPage.isUserDisplayedInList(userName));
        //assertEquals(userName,usersPage.isAddedUser(userName));

        //assertTrue(usersPage);
    }
//    @And("^I have 3 Users added$")
//    public void I_have_3_Users_added(){
//        usersPage=usersNewPage.addNewUserSuccessful(userName,userEmail,checkBox);
//
//    }
    @When("^I suspend to user \"([^\"]*)\"$")
    public void I_suspend_to_user(String userName){
        //usersPage.setSuspendedUsers(userName);
        usersPage.clickSuspendUserBtn(userName);
        //assert
    }

    @Then("^I should not able to view to suspended user \"([^\"]*)\" on the Users list$")
    public void I_should_not_able_to_view_to_suspended_user_on_the_Users_list(String userName){
        //assertFalse(usersPage.findUserOnList(userName));
        assertFalse(usersPage.isUserDisplayedInList(userName));
    }

    @And("^I should be able view the user suspended \"([^\"]*)\" on the suspended user list$")
    public void I_should_be_able_view_the_user_suspended_on_the_suspended_user_list(String userName){
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
    public void I_should_be_able_to_view_to_reactive_user_on_Users_lis(String userName){
        assertTrue(usersPage.isUserDisplayedInList(userName));
        //assertTrue(usersPage.isAddedUser(userName));
    }

}
