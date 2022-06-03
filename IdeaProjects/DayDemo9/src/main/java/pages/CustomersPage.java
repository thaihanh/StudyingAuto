package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomersPage extends BasePage {
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Customers']")
    private WebElement customersTitle;

    @FindBy(id = "add")
    private WebElement addNewCustomerBtn;

    @FindBy(xpath = "//div[@id = 'messages']//div[@data-ui-id='messages-message-success']")
    private WebElement successMsg;

    public boolean verifyCustomer(){
        getWait().until(ExpectedConditions.visibilityOf(customersTitle));
        return customersTitle.isDisplayed();
    }
    public void clickAddNewCustomerBtn(){
        getWait().until(ExpectedConditions.visibilityOf(addNewCustomerBtn));
        addNewCustomerBtn.click();
    }
    public boolean verifyMsg(){
        getWait().until(ExpectedConditions.visibilityOf(customersTitle));
        return successMsg.isDisplayed();
    }
}
