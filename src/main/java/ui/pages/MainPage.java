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
 * Date: 11/11/15
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainPage extends BasePageObject {
    @FindBy(id="dashboard_items_list")
    @CacheLookup
    WebElement dashboardItemsList;

    @FindBy(className="navbar-inner")
    @CacheLookup
    WebElement mainNavBar;

    @FindBy(className = "actions_pane no_reorder")
    @CacheLookup
    WebElement rightPane;

    //@FindBy(className = "dropdown pull-right")
    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/ul[2]/li[2]/a")
    @CacheLookup
    WebElement dropDownButton;

    //@FindBy(className = "icon-et-logout")
    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/ul[2]/li[2]/ul/li[2]/a/span")
    @CacheLookup
    WebElement  logOutPage;

    public MainPage(){
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(dashboardItemsList));
    }


    /*private MainPage isUserNameDisplayed(){

    }*/

    public boolean isUserNameDisplayed(){

        return mainNavBar.isDisplayed();

    }

    //private MainPage

    public LoginPage logOut(){
        dropDownButton.click();
        logOutPage.click();
        return new LoginPage();
    }


    
}
