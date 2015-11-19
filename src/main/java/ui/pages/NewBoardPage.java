package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/19/15
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewBoardPage extends BasePageObject {
    @FindBy(id = "board_name")
    @CacheLookup
    WebElement inputBoardName;

    @FindBy(id = "board_description")
    @CacheLookup
    WebElement inputBoardDescription;

    @FindBy(id = "template_select")
    @CacheLookup
    WebElement templateSelectList;

    @FindBy(id = "customize_workflow")
    @CacheLookup
    WebElement customizeCheckOut;

    @FindBy(id = "submit_form_button")
    @CacheLookup
    WebElement submitBtn;

    @FindBy(linkText = "cancel")
    @CacheLookup
    WebElement cancelLink;

    @FindBy(linkText = "Go back to dashboard view")
    @CacheLookup
    WebElement goBackLink;

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private NewBoardPage setBoardNameInput(String boardName){
        inputBoardName.clear();
        inputBoardName.sendKeys(boardName);
        return this;
    }

    private NewBoardPage setBoardDescriptionInput(String boardDescription){
        inputBoardDescription.clear();
        inputBoardDescription.sendKeys(boardDescription);
        return this;
    }

    private NewBoardPage clickCreateNewBoardBtn(){
        submitBtn.click();
        return this;
    }

    private NewBoardPage clickCancelBtn(){
        cancelLink.click();
        return this;
    }

    private DashBoardPage clickGoBackBtn(){
        goBackLink.click();
        return new DashBoardPage();
    }
}
