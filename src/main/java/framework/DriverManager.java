package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/10/15
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class DriverManager {

    private WebDriver driver;
    private WebDriverWait wait;

    private static DriverManager instance=null;

    //final static Logger logger = Logger.getLogger(DriverManager.class);

    /*public String GetBaseAddress(){
            return "http://wordpressautomation.azurewebsites.net/";
    }  */
    /*private FirefoxProfile GetFirefoxProfile()
    {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("network.automatic-ntlm-auth.trusted-uris", "http://localhost");
        return firefoxProfile;
    } */


    public void Init(){
        //profile=new Profile();
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        driver=new FirefoxDriver();

        //driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait= new WebDriverWait(driver, 30, 100);
    }

    public void Close(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private DriverManager(){
        Init();
    }

    /*public WebDriver getWebDriver(){

    }*/

    //private static DriverManager instance;

    /*private synchronized static void Instance() {
        if(instance==null||instance.driver == null)
        {
            instance = new DriverManager();
        }
    } */
    public static DriverManager getInstance() {
        //Instance();
        if(instance==null||instance.driver == null)
        {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
    public WebDriverWait getWait() {
        return wait;
    }


}



