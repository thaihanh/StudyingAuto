package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "(//input[@class='admin__control-text'])[2]")
    private WebElement firstName;

    @FindBy(xpath = "(//input[@class='admin__control-text'])[4]")
    private WebElement lastName;

    @FindBy(xpath = "(//input[@class='admin__control-text'])[6]")
    private WebElement email;

    @FindBy(id = "save")
    private WebElement saveBtn;

    public boolean verifyNewCustomer(){
        getWait().until(ExpectedConditions.visibilityOf(newCustomersTitle));
        return newCustomersTitle.isDisplayed();
    }

    public void inputRequiredField(String website, String gr, String first, String last, String mail){
        getWait().until((ExpectedConditions.visibilityOf(associateToWebsite)));
        Select s1 = new Select(associateToWebsite);
        s1.selectByVisibleText(website);
        Select s2 = new Select(group);
        s2.selectByVisibleText(gr);
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        email.sendKeys(mail);
    }

    public void clickSaveBtn(){
        getWait().until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
    }
}
