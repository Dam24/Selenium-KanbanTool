package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/30/15
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SharingBoardPage extends BasePageObject {

    @FindBy(id = "users_list")
    @CacheLookup
    WebElement userList;

    @FindBy(className = "show_suspended")
    @CacheLookup
    WebElement showSuspended;

    @FindBy(className = "new_user enabled")
    @CacheLookup
    WebElement addNewPerson;

    @FindBy(id = "save_button")
    @CacheLookup
    WebElement saveAndContinueBtn;

    public SharingBoardPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private BoardPage clickSaveAndContinueBtn(){
        saveAndContinueBtn.click();
        return new BoardPage();
    }

    public BoardPage setSharingBoard(){
        return clickSaveAndContinueBtn();
    }
}
