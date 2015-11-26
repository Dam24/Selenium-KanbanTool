package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/16/15
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class UsersSuspendedPage extends BasePageObject{

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected UsersPage usersPage;

    @FindBy(linkText = "Go back to active users list")
    @CacheLookup
    WebElement goBackBtn;

    @FindBy(xpath = "//table[contains(@class, 'table-condensed')]/tbody")
    @CacheLookup
    WebElement tableUsersSuspended;

    @FindBy(xpath = "//div[1]/p")
    @CacheLookup
    WebElement successfullMessage;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(goBackBtn));
    }

    public void clickReactivateUserBtn(String userName){
        WebElement reactivateBtn=tableUsersSuspended.findElement(By.xpath("//tr[td[contains(text(),'" + userName + "')]]/td[3]/a[1]"));
        System.out.println("suspend Button:   "+ reactivateBtn.getText());
        reactivateBtn.click();
    }
    public void clickDeleteUserBtn(String userName){
        WebElement deleteBtn=tableUsersSuspended.findElement(By.xpath("//tr[td[contains(text(),'" + userName + "')]]/td[3]/a[2]"));
        System.out.println("suspend Button:   "+ deleteBtn.getText());
        deleteBtn.click();
    }

    public boolean isAddedSuspendedUser(String userName){
        usersPage.clickSuspendUsers();

        wait.until(ExpectedConditions.visibilityOf(tableUsersSuspended));
        // wait.until(al);
        //       Thread.sleep(5000);
////        WebElement element=tableUsers.findElement(By.xpath("//td[contains(text(),'" + userName + "')]"));
////        System.out.println("user encontrado:   "+element.getText());
        return tableUsersSuspended.findElement(By.xpath("//td[contains(text(),'" + userName + "')]")).isDisplayed();

        //return true;
    }

    public void reactivateUser(String userName){

    }

    public boolean isMessageDisplayed(){
        return successfullMessage.isDisplayed();
    }



}
