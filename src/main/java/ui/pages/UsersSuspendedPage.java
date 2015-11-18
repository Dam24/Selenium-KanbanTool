package ui.pages;

import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/16/15
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class UsersSuspendedPage extends BasePageObject{

    public boolean isAddedSuspendedUser(String userName){
        return true;
    }

    public void reactivateUser(String userName){

    }

    public boolean isMessageDisplayed(){
        return true;
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
