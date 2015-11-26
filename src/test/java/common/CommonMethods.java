package common;

import ui.PageTransporter;
import ui.pages.LoginPage;
import ui.pages.MainPage;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/11/15
 * Time: 8:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonMethods {
   // private MainPage mainPage;

    /**
     * Log outs from the web app
     */

    public static void logOut() {
        //private mainPage = new MainPage();
        MainPage mainPage=new MainPage();
        mainPage.logOut();
    }

    public static void LogIn(){
        LoginPage loginPage=new LoginPage();
        PageTransporter.getInstance().navigateToLoginPage();
        loginPage.loginSuccessful("Damian.Villanueva@fundacion-jala.org","Control123");
    }




//    private static PageTransporter pageTransporter = PageTransporter.getInstance();
//
//
//    public static void logIn() {
//        pageTransporter
//                .navigateToMainPage() .
//                .clickLogInButton()
//                .loginSuccessful("Jhasmany.Quiroz@fundacion-jala.org", "1c7hu57&7")
//        ;
//    }



}
