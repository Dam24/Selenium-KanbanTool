package common;

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


}
