package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h1[text()='Dashboard']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//div[@class='modal-inner-wrap']")
    private WebElement incomingMsg;

    @FindBy(xpath = "//div[@class='modal-inner-wrap']//button")
    private WebElement closeMsgBtn;

    @FindBy(xpath = "//div[@class='menu-wrapper _fixed']")
    private WebElement menuLeft;

    @FindBy(xpath = "//li[@id='menu-magento-customer-customer']")
    private WebElement customersMenuItem;

    @FindBy(xpath = "//li[@class='item-customer-manage    level-1']//span")
    private WebElement allCustomersSubMenu;

    public boolean verifyDashboard(){
        getWait().until(ExpectedConditions.visibilityOf(dashboardTitle));
        return dashboardTitle.isDisplayed();
    }

    public boolean verifyIncomingMsg(){
        getWait().until(ExpectedConditions.visibilityOf(incomingMsg));
        return incomingMsg.isDisplayed();
    }

    public void clickCloseMsg(){
        getWait().until(ExpectedConditions.visibilityOf(closeMsgBtn));
        closeMsgBtn.click();
    }

    public boolean verifyMenuLeft(){
        getWait().until(ExpectedConditions.visibilityOf(menuLeft));
        return menuLeft.isDisplayed();
    }
    public void clickCustomersMenuItem(){
        getWait().until(ExpectedConditions.visibilityOf(customersMenuItem));
        customersMenuItem.click();
    }
    public void clickAllCustomersSubMenu(){
        getWait().until(ExpectedConditions.visibilityOf(allCustomersSubMenu));
        allCustomersSubMenu.click();
    }

}
