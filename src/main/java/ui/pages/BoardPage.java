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
 * Date: 11/26/15
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardPage extends BasePageObject {

    @FindBy(xpath = "//*[@id=\"show\"]/nav/div/h2/span")
    @CacheLookup
    WebElement boardTitle;

    @FindBy(xpath = "//*[@id=\"show\"]/div[1]/kt-board")
    //@FindBy(xpath = "//kt-board")
    @CacheLookup
    WebElement dataBoard;

    public BoardPage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dataBoard));
    }


    public boolean isBoardPresent(){
        return dataBoard.isDisplayed();
    }





}
