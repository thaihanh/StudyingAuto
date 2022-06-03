package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "login")
    private WebElement password;

    @FindBy(xpath = "//a[@class=\"action-forgotpassword\"]")
    private WebElement forgotLink;

    @FindBy(xpath = "//span[text()='Sign in']//..")
    private WebElement loginBtn;

    public void navigateToLogin(String url) {
        getDriver().get(url);
    }

    public void login(String u, String p) {
        getWait().until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(u);
        password.sendKeys(p);
        loginBtn.click();
    }

    public boolean verifyLoginPage() {
        getWait().until(ExpectedConditions.visibilityOf(username));
        return username.isDisplayed() &&
                password.isDisplayed() &&
                forgotLink.isDisplayed() &&
                loginBtn.isDisplayed();
    }
}
