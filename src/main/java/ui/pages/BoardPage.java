package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        System.out.println("entro al metodo");
        wait.until(ExpectedConditions.visibilityOf(dataBoard));

        WebElement addTaskBtn= dataBoard.findElement(By.xpath("//tbody/tr/td[span[contains(text(),'"+columnName+"')]]/kt-tasklist/div[1]/a[2]"));
        System.out.println("addTaskBtn: "+addTaskBtn.getText());
        addTaskBtn.click();
        return new TaskPage();
    }


    public boolean isTaskPresent(String taskName, String columnName){

        WebElement task= dataBoard.findElement(By.xpath("//kt-board/tbody/tr/td[span[contains(text(),'" + columnName + "')]]/kt-tasklist/kt-task[div[contains(text(),'" + taskName + "')]]"));

        return task.isDisplayed();

    }

    private TaskPage clickEditTask(String columnName, String taskName){
        WebElement editTask= dataBoard.findElement(By.xpath("//kt-board/tbody/tr/td[span[contains(text(),'" + columnName + "')]]/kt-tasklist/kt-task[div[contains(text(),'" + taskName + "')]]"));
        editTask.click();
        return new TaskPage();
    }


    public void setEditTask(String columnName, String taskName, String newTaskName){
        clickEditTask(columnName, taskName);
        taskPage.editTask(newTaskName);
    }









}
