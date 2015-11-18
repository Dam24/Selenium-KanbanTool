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
 * Time: 8:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends BasePageObject{
    @FindBy(id = "login_input")
    @CacheLookup
    WebElement userNameInput;

    @FindBy(id = "password_input")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(id = "login_button")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/p")
    WebElement loginErrorMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
    }

    private LoginPage setUserNameInput(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    private LoginPage setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    private MainPage clickLoginBtnSuccessful() {
        loginBtn.click();
        return new MainPage();
    }


    public LoginPage clickLoginBtnFailed() {
        loginBtn.click();
        return this;
    }

    private void login(String userName, String password) {
        setUserNameInput(userName);
        setPasswordInput(password);
    }

    public MainPage loginSuccessful(String userName, String password) {
        login(userName, password);
        return clickLoginBtnSuccessful();
    }

    public LoginPage loginFailed(String userName, String password) {
        login(userName, password);
        return clickLoginBtnFailed();
    }

    public Boolean getErrorMessage() {
        return loginErrorMessage.isDisplayed();
    }

    /*public String getErrorMessage() {
        return loginErrorMessage.getText();
    }*/
}
