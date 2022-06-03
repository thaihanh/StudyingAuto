package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewCustomerPage extends BasePage {
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='New Customer']")
    private WebElement newCustomersTitle;

    @FindBy(xpath = "(//select[@class='admin__control-select'])[1]")
    private WebElement associateToWebsite;

    @FindBy(xpath = "(//select[@class='admin__control-select'])[2]")
    private WebElement group;

    @FindBy(id = "P0B3X1A")
    private WebElement firstName;

    @FindBy(id = "P0B3X1A")
    private WebElement firstName;


    public boolean verifyNewCustomer(){
        getWait().until(ExpectedConditions.visibilityOf(newCustomersTitle));
        return newCustomersTitle.isDisplayed();
    }


}
