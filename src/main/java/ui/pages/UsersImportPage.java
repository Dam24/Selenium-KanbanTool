package ui.pages;

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
 * Date: 11/19/15
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class UsersImportPage extends BasePageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected UsersPage usersPage;

    @FindBy(id = "import_text")
    @CacheLookup
    WebElement textArea;

    @FindBy(className = "btn btn-success")
    @CacheLookup
    WebElement successBtn;

    @FindBy(linkText = "cancel")
    @CacheLookup
    WebElement cancelBtn;

    @FindBy(className = "back-link")
    @CacheLookup
    WebElement closeBtn;

    @FindBy(id = "import_file")
    @CacheLookup
    WebElement selectFileBtn;

    @FindBy(className = "icon-et-help-circled")
    @CacheLookup
    WebElement helpIcon;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(successBtn));
    }

    public void clickSuccessBtn(){
        successBtn.click();
    }
    public void clickCancelBtn(){
        cancelBtn.click();
    }
    public void clickCloseBtn(){
        closeBtn.click();
    }
    public void clickSelectFileBtn(){
        selectFileBtn.click();
    }

    public void setTextArea(String [][] usersList){
        for(int i=0; i<usersList.length;i++){
           // for(int j=0; i<usersList[i].length;i++){
                textArea.sendKeys(usersList[i][0]+", "+usersList[i][1]+", "+usersList[i][2]+"\n");
           // }
        }

    }

}
