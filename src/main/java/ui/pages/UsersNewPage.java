package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/16/15
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class UsersNewPage extends BasePageObject{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected UsersPage usersPage;

    @FindBy(id = "user_name")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(id = "user_email")
    @CacheLookup
    WebElement userEmailInput;

    @FindBy(id = "user_extra_infoe")
    @CacheLookup
    WebElement userExtraInfoInput;

    @FindBy(id = "user_is_project_manager")
    @CacheLookup
    WebElement userProjectManagerCheck;

    @FindBy(id = "user_is_account_admin")
    @CacheLookup
    WebElement userAccountAdminCheck;

    @FindBy(id = "user_is_account_owner")
    @CacheLookup
    WebElement userAccountOwnerCheck;

    @FindBy(linkText = "cancel")
    @CacheLookup
    WebElement btnCancel;

    @FindBy(name = "button")
    @CacheLookup
    WebElement btnAdd;

    @FindBy(id = "new_user")
    @CacheLookup
    WebElement newUserCont;
//    public UsersNewPage(){
//        PageFactory.initElements(driver, this);
//        waitUntilPageObjectIsLoaded();
//    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
//        wait.until(ExpectedConditions.visibilityOf(btnAdd));
    }

    private UsersNewPage setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    private UsersNewPage setUserEmailInput(String userName) {
        userEmailInput.clear();
        userEmailInput.sendKeys(userName);
        return this;
    }

    private UsersNewPage setUserExtraInfoInput(String userName) {
        userExtraInfoInput.clear();
        userExtraInfoInput.sendKeys(userName);
        return this;
    }

    public UsersNewPage clickUserAccountAdminCheck() {
        userAccountAdminCheck.click();
        return this;
    }

    public UsersNewPage clickUserProjectManagerCheck() {
        userProjectManagerCheck.click();
        return this;
    }

    public UsersNewPage clickUserAccountOwnerCheck() {
        userAccountOwnerCheck.click();
        return this;
    }

    public UsersPage clickBtnCancel() {
        btnCancel.click();
        return new UsersPage();
    }

    public UsersPage clickBtnAdd() {
        btnAdd.click();
        return new UsersPage();
    }

    private void fillAddNewPerson(String userName, String email){
        setUserNameInput(userName);
        setUserEmailInput(email);
    }
    private void selectCheckBox(String checkBox){
        if (checkBox.contentEquals("Project manager")){
            clickUserProjectManagerCheck();
        }
        else if(checkBox.contentEquals("Account administrator")){
            clickUserAccountAdminCheck();
        }
        else if(checkBox.contentEquals("Account owner")){
            clickUserAccountOwnerCheck();
        }
    }

    //todo pending

    public UsersPage addNewUserSuccessful(String userName, String email, String checkBox){

        fillAddNewPerson(userName, email);
        selectCheckBox(checkBox);
        return clickBtnAdd();
    }
}
