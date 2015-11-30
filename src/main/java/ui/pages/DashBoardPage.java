package ui.pages;

import org.openqa.selenium.Alert;
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
 * Date: 11/19/15
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class DashBoardPage extends BasePageObject{
    public MainPage mainPage;

    @FindBy(id = "dashboard_items_list")
    @CacheLookup
    WebElement boardsList;

    @FindBy(className = "actions_pane no_reorder")
    @CacheLookup
    WebElement actionsPane;

    @FindBy(linkText = "Create new board")
    //@FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[1]/ul/li[1]/a")
    @CacheLookup
    WebElement createNewBoardLink;

    @FindBy(className = "Create new folder")
    @CacheLookup
    WebElement createNewFolderLink;

    @FindBy(className = "Reorder items")
    @CacheLookup
    WebElement reorderItemsLink;

    @FindBy(xpath = "//*[@id=\"more_menu\"]/a[3]")
    @CacheLookup
    WebElement deleteBoardBtn;

    public DashBoardPage() {
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }


    @Override
    public void waitUntilPageObjectIsLoaded() {
//        wait.until(ExpectedConditions.visibilityOf(actionsPane));
    }

    public NewBoardPage clickCreateNewBoardLink(){
        //wait.until(ExpectedConditions.visibilityOf(createNewBoardLink));
        createNewBoardLink.click();
        return new NewBoardPage();
    }
    public FoldersNewPage clickCreateNewFolderLink(){
        createNewFolderLink.click();
        return new FoldersNewPage();
    }

    //revisar
    public void clickReorderItemsLink(){
        reorderItemsLink.click();
    }


    public void clickMoreLink(){
        //li[@id='items_board.184834']/div[2]/a[2]/
        WebElement moreLink=boardsList.findElement(By.xpath("//li[@id='items_board.184834']/div[2]/a[2]/"))  ;

        //WebElement editBtn=tableUsers.findElement(By.xpath("//tr[td[contains(text(),'" + userName + "')]]/td[3]/a[1]"));
        //System.out.println("suspend Button:   "+ editBtn.getText());
        moreLink.click();
    }
    public void setNewBoard(String boardName, String boardDescription, String boardTemplate){
        clickCreateNewBoardLink();

    }

    public boolean isBoardDisplayedOnList(String boardName){
        wait.until(ExpectedConditions.visibilityOf(boardsList));
        return boardsList.findElement(By.xpath("//a[contains(text(),'"+boardName+"')]")).isDisplayed();
    }

//    public LoginPage logOut(){
//        mainPage.dropDownButton.click();
//        mainPage.logOutPage.click();
//        return new LoginPage();
//    }

    private DashBoardPage clickBoardMoreBtn(String boardName){
        WebElement moreBtn=boardsList.findElement(By.xpath("//div[4]/ul/li[div/span/a[contains(text(),'"+boardName+"')]]/div[2]/a[2]/"));
        moreBtn.click();
        return this;
    }
    private DashBoardPage clickDeleteBoardBtn(){
        deleteBoardBtn.click();
        return this;
    }

    public void setDeleteBoard(String boardName){

        String parentWindow = driver.getWindowHandle();
        try{
            clickBoardMoreBtn(boardName);
            clickDeleteBoardBtn();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("alert message: "+alert.getText());
            alert.accept();
        }finally {
            driver.switchTo().window(parentWindow);
        }
    }

}
