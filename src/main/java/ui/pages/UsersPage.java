package ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.BasePageObject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by peniel on 16/11/2015.
 */
public class UsersPage extends BasePageObject {

    @FindBy(className = "actions_pane")
    @CacheLookup
    WebElement actionsPane;

    @FindBy(xpath = "//table[contains(@class, 'table-condensed')]/tbody")
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

    @FindBy(className = "brand")
    @CacheLookup
    WebElement brand;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/p")
    @CacheLookup
    WebElement suspendMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/p")
    @CacheLookup
    WebElement createdMessage;
    public UsersPage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(actionsPane));
    }

    public UsersNewPage clickAddBtn(){
        //actionsPane.findElement(By.linkText("Add new person")).click();
        addNewPerson.click();
        return new UsersNewPage();
    }

    public UsersSuspendedPage clickSuspendUsers(){
        suspendedUsers.click();
        return new UsersSuspendedPage();
    }

    public UsersImportPage clickInviteWholeTeam(){
        inviteWholeTeam.click();
        return new UsersImportPage();
    }

    public boolean findUserOnList(String userName){
        boolean res = false;
        List<WebElement> list = tableUsers.findElements(By.tagName("tr"));

        Iterator<WebElement> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Elemento: " + iterator.next().getText());
            //iterator.next()
            WebElement name= iterator.next().findElement(By.xpath("td[1]"));
            //List<WebElement> list1 = iterator.next().findElements(By.tagName("td[0]"));
            System.out.println(name.getText());
            //iterator.next().findElements(By.tagName("td"))
            //if(list1.get().equals(userName)){
            if (name.getText().equalsIgnoreCase(userName)) {
                res = true;
            }
        }
        return res;
    }

    public void setSuspendedUsers(String userName){
        List<WebElement> list = tableUsers.findElements(By.tagName("tr"));
        System.out.println("Lista de Elementos: " + list);
        Iterator<WebElement> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Elemento: " + iterator.next().getText());
            WebElement name= iterator.next().findElement(By.xpath("td[1]"));

            System.out.println(name.getText());
            if (name.getText().equalsIgnoreCase(userName)) {
                WebElement suspendedLink= name.findElement(By.xpath("//td[3]/a[contains(text(),'suspend')]"));

                suspendedLink.click();
            }
        }
    }

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }//try
        catch(Exception e){
            return false;
        }//catch
    }

    public void clickSuspendUserBtn(String userName) throws InterruptedException {
        WebElement suspendBtn=tableUsers.findElement(By.xpath("//tr[td[contains(text(),'"+userName+"')]]/td[3]/a[2]"));
        String parentWindow = driver.getWindowHandle();
        try{
            suspendBtn.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("alert message: "+alert.getText());
            alert.accept();
        }finally {
            driver.switchTo().window(parentWindow);
        }
    }

    private boolean isSuspendedMessagePresent(){
        return suspendMessage.isDisplayed();
    }

    public String getSuspendedMessage(){
        System.out.println("message exist: "+isSuspendedMessagePresent());
        return suspendMessage.getText();
    }

    public String getCreatedUserMessage(){
        System.out.println("message: "+createdMessage.getText());
        return createdMessage.getText();
    }

    public void clickEditUserBtn(String userName){
        WebElement editBtn=tableUsers.findElement(By.xpath("//tr[td[contains(text(),'"+userName+"')]]/td[3]/a[1]"));
        System.out.println("suspend Button:   "+ editBtn.getText());
        editBtn.click();
    }

    public boolean isUserDisplayedInList(String userName) throws InterruptedException {
        try {
            WebElement user= tableUsers.findElement(By.xpath("//td[contains(text(),'" + userName + "')]"));
            return user.isDisplayed();

        }   catch(Exception e){
            return false;
        }
    }
}
