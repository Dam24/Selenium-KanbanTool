package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.BasePageObject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by peniel on 16/11/2015.
 */
public class UsersPage extends BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(className = "actions_pane")
    @CacheLookup
    WebElement actionsPane;

//    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table")
//    @CacheLookup
//    WebElement tableUsers;

    //@FindBy(xpath = "//table[contains(@class, 'table-condensed')]/tbody")
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
    //@FindBy(linkText = "suspend")
//    @FindBy(xpath = "xpath=(//a[contains(text(),'suspend')])")
//    @CacheLookup
//    WebElement suspendButton;


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



//    public boolean isAddedUser(String userName){
//
//        //return tableUsers.getText().contains(userName);
//        return tableUsers.findElement(By.linkText(userName)).isDisplayed();
//        //return tableUsers.findElement(By.name(userName)).isDisplayed();
//        //return tableUsers.isDisplayed();
//        //return true;
//    }

    /*
    tableUsers:WebElement de la tabla de Usuarios


     */
    public boolean findUserOnList(String userName){
        boolean res = false;

        List<WebElement> list = tableUsers.findElements(By.tagName("tr"));

        System.out.println("Lista de Elementos: " + list);


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
        //tableUsers.findElement(By.linkText(userName)).findElement(By.linkText("suspend")).click();
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

        //suspendButton.click();
        //td[3]/a[contains(text(),'suspend')]
    }

    public void clickSuspendUserBtn(String userName){
        WebElement suspendBtn=tableUsers.findElement(By.xpath("//tr[td[contains(text(),'"+userName+"')]]/td[3]/a[2]"));
        System.out.println("suspend Button:   "+ suspendBtn.getText());
        suspendBtn.click();
    }
    public void clickEditUserBtn(String userName){
        WebElement editBtn=tableUsers.findElement(By.xpath("//tr[td[contains(text(),'"+userName+"')]]/td[3]/a[1]"));
        System.out.println("suspend Button:   "+ editBtn.getText());
        editBtn.click();

    }

    public boolean isUserDisplayedInList(String userName) {
        WebElement element=tableUsers.findElement(By.xpath("//td[contains(text(),'" + userName + "')]"));
        System.out.println("user encontrado:   "+element.getText());
        return tableUsers.findElement(By.xpath("//td[contains(text(),'" + userName + "')]")).isDisplayed();
    }

//    public boolean isSuspendedUser(String userName){
//        return suspendedUsers.findElement(By.linkText(userName)).isDisplayed();
//    }






}
