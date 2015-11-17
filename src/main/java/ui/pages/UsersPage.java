package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by peniel on 16/11/2015.
 */
public class UsersPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(className = "actions_pane")
    @CacheLookup
    WebElement actionsPane;

    @FindBy(className = "table table-condensed")
    @CacheLookup
    WebElement tableUsers;

    @FindBy(linkText = "Add new person")
    @CacheLookup
    WebElement addNewPerson;

    @FindBy(linkText = "Invite a whole team")
    @CacheLookup
    WebElement inviteWholeTeam;

    @FindBy(linkText = "Show suspended users")
    @CacheLookup
    WebElement suspendedUsers;

//    @Override
//    public void waitUntilPageObjectIsLoaded() {
//        wait.until(ExpectedConditions.visibilityOf(actionsPane));
//    }

    public boolean isAddedUser(String userName){
        return tableUsers.findElement(By.linkText(userName)).isDisplayed();
    }

    public void setSuspendedUsers(String userName){
        tableUsers.findElement(By.linkText(userName)).findElement(By.linkText("suspend")).click();
    }

    public boolean isSuspendedUser(String userName){
        return suspendedUsers.findElement(By.linkText(userName)).isDisplayed();
    }




}
