package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ui.BasePageObject;
import ui.PageTransporter;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/26/15
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardNavBarPage extends BasePageObject {
    @FindBy(className = "navbar-inner")
    @CacheLookup
    WebElement navBar;

    @FindBy(xpath = "//body[@id='show']/nav/div/h2")
    @CacheLookup
    WebElement brandName;

    @FindBy(linkText = "Board")
    @CacheLookup
    WebElement navBoard;

    @FindBy(linkText = "Analytics")
    @CacheLookup
    WebElement navAnalytics;

    @FindBy(linkText = "Settings")
    @CacheLookup
    WebElement navSettings;

    //@FindBy(linkText = "Exit")
    @FindBy(xpath = "//a[contains(text(),'Exit')]")
    @CacheLookup
    WebElement navExit;

    public BoardNavBarPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(navBar));
    }

    private BoardPage clickBoardButton(){
        navBoard.click();
        return new BoardPage();
    }
}
