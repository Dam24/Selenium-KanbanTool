package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
    public BoardNavBarPage boardNavBarPage;
    public TaskPage taskPage;

    @FindBy(xpath = "//*[@id=\"show\"]/nav/div/h2/span")
    @CacheLookup
    WebElement boardTitle;

    //@FindBy(xpath = "//*[@id=\"show\"]/div[1]/kt-board")
    @FindBy(xpath = "//kt-board")
    @CacheLookup
    WebElement dataBoard;

    @FindBy(xpath = "//kt-wip-counter")
    @CacheLookup
    WebElement boardCounter;

    @FindBy(xpath = "//a[contains(text(),'Exit')]")
    @CacheLookup
    WebElement navExit;

    @FindBy(className = "kt-collaboration-pane-icon active")
    @CacheLookup
    WebElement collaborationIcon;

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

    public TaskPage clickAddTask(String columnName)throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(dataBoard));
        WebElement addTaskBtn= dataBoard.findElement(By.xpath("//tbody/tr/td[span[contains(text(),'"+columnName+"')]]/kt-tasklist/div[1]/a[2]"));
        addTaskBtn.click();
        return new TaskPage();
    }

    public boolean isTaskPresent(String taskName, String columnName){
        wait.until(ExpectedConditions.visibilityOf(dataBoard));
        WebElement task= dataBoard.findElement(By.xpath("//tbody/tr/td[span[contains(text(),'" + columnName + "')]]/kt-tasklist/kt-task[div[contains(text(),'" + taskName + "')]]"));
        return task.isDisplayed();
    }

    public TaskPage clickEditTask(String columnName, String taskName){
        WebElement editTask= dataBoard.findElement(By.xpath("//kt-board/tbody/tr/td[span[contains(text(),'" + columnName + "')]]/kt-tasklist/kt-task[div[contains(text(),'" + taskName + "')]]"));
        editTask.click();
        return new TaskPage();
    }

    public void setEditTask(String columnName, String taskName, String newTaskName){
        clickEditTask(columnName, taskName);
        taskPage.editTask(newTaskName);
    }

    public void moveTask(String taskName, String columnName, String columnDestine){
        WebElement selectedTask= dataBoard.findElement(By.xpath("//kt-board/tbody/tr/td[span[contains(text(),'" + columnName + "')]]/kt-tasklist/kt-task[div[contains(text(),'" + taskName + "')]]"));
        WebElement column= dataBoard.findElement(By.xpath("//kt-board/tbody/tr/td[span[contains(text(),'" + columnDestine + "')]]"));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(selectedTask)
                .moveToElement(column)
                .release(column)
                .build();
        dragAndDrop.perform();
    }

    public DashBoardPage clickExitButton(){
        navExit.click();
        return new DashBoardPage();
    }
}
