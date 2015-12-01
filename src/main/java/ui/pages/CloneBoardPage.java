package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/30/15
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class CloneBoardPage extends BasePageObject {

    @FindBy(id = "item_name")
    @CacheLookup
    WebElement newNameField;

    @FindBy(id = "item_description")
    @CacheLookup
    WebElement itemDescription;

    @FindBy(xpath = "//*[@id=\"new_item\"]/div[5]/button")
    @CacheLookup
    WebElement cloneNowBtn;

    @FindBy(xpath = "//*[@id=\"new_item\"]/div[5]/span/a")
    @CacheLookup
    WebElement cancelBtn;

    public CloneBoardPage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(cloneNowBtn));
    }

    private CloneBoardPage setNewNameField(String boardName){
        newNameField.clear();
        newNameField.sendKeys(boardName);
        return this;
    }

    private CloneBoardPage setItemDescriptionField(String description){
        itemDescription.clear();
        itemDescription.sendKeys(description);
        return this;
    }

    private DashBoardPage clickCloneNowBtn(){
        cloneNowBtn.click();
        return new DashBoardPage();
    }

    private DashBoardPage clickCancelBtn(){
        cancelBtn.click();
        return new DashBoardPage();
    }

    public DashBoardPage setCloneBoard(String boardName){
        setNewNameField(boardName);
        setItemDescriptionField("Description");
        clickCloneNowBtn();
        return new DashBoardPage();
    }
}
