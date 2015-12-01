package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: DamianVillanueva
 * Date: 11/27/15
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskPage extends BasePageObject {
    @FindBy(xpath = "//*[@id=\"show\"]/kt-cover/kt-taskview/form/div[1]/h1/textarea")
    @CacheLookup
    WebElement taskNameField;

    @FindBy(xpath = "//div[4]/button[1]")
    @CacheLookup
    WebElement createAndCLoseBtn;

    @FindBy(xpath = "//div[4]/button[2]")
    @CacheLookup
    WebElement createAndAddNextBtn;

    @FindBy(xpath = "//div[4]/button[3]")
    @CacheLookup
    WebElement createAndEditBtn;

    @FindBy(className = "kt-task-close")
    @CacheLookup
    WebElement closeTask;

    public TaskPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    @Override
    public void waitUntilPageObjectIsLoaded() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private TaskPage setTaskNameField(String taskName){
        taskNameField.clear();
        taskNameField.sendKeys(taskName);
        return this;
    }

    private BoardPage clickCreateAndCLoseBtn(){
        createAndCLoseBtn.click();
        return new BoardPage();
    }

    private TaskPage clickCreateAndAddNextBtn(){
        createAndAddNextBtn.click();
        return new TaskPage();
    }

    private TaskPage clickCreateAndEditBtn(){
        createAndEditBtn.click();
        return this;
    }
    private BoardPage clickCloseTaskBtn(){
        closeTask.click();
        return new BoardPage();
    }

    public BoardPage SetNewTask(String taskName){
        setTaskNameField(taskName);
        return clickCreateAndCLoseBtn();
    }

    public BoardPage editTask(String taskName){
        setTaskNameField(taskName);
        return clickCloseTaskBtn();
    }
}
