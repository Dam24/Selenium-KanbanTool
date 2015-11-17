package ui;

//import framework.CredentialsManager;
//import framework.selenium.DriverManager;
import  framework.DriverManager;
import org.openqa.selenium.WebDriver;
/*import ui.admin.pages.LoginTSAdminPage;
import ui.monitor.ApplicationsPage;
import ui.web.pages.LoginTSWebPage;*/
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.UsersPage;
import ui.pages.UsersSuspendedPage;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/11/15
 * Time: 8:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class PageTransporter {
    private WebDriver driver = DriverManager.getInstance().getWebDriver();
    private String baseLoginURL = "https://penieldamian.kanbantool.com/";
    private String baseMainPage = "https://penieldamian.kanbantool.com/";
    private String baseUsersPage = "https://penieldamian.kanbantool.com/users";
    private String baseUsersSuspended ="https://penieldamian.kanbantool.com/users/suspended";
    private static PageTransporter instance;

    protected PageTransporter() {
        initialize();
    }

    public static PageTransporter getInstance() {
        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void initialize() {
//        log.info("Initialize the page transporter");
    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public LoginPage navigateToLoginPage() {
        goToURL(baseLoginURL);
        return new LoginPage();
    }

    public MainPage navigateToMainPage(){
        goToURL(baseMainPage);
        return new MainPage();
    }

    public UsersPage navigateToUsersPage(){
        goToURL(baseUsersPage);
        return new UsersPage();
    }
    public UsersSuspendedPage navigateToUserSuspendedPage(){
        goToURL(baseUsersSuspended);
        return new UsersSuspendedPage();
    }
}
