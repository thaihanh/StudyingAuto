package practiceDay6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC_01 {
    @Test
    public void verifyLoginPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement email = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        Assert.assertTrue(email.isDisplayed());
        String actualDefaultEmail = email.getAttribute("value");
        String expectedDefaultEmail = "admin@email.com";
        Assert.assertEquals(actualDefaultEmail, expectedDefaultEmail, "Default value is wrong");

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        Assert.assertTrue(password.isDisplayed());
        String actualDefaultPW= password.getAttribute("value");
        String expectedDefaultPW= "123456";
        Assert.assertEquals(actualDefaultPW, expectedDefaultPW, "Default password is wrong");

        WebElement loginBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and text()='Login']")));
        Assert.assertTrue(loginBtn.isDisplayed());

        WebElement checkboxRememberMe = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remember-me")));
        Assert.assertTrue(checkboxRememberMe.isDisplayed());

        WebElement forgotPW = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" +
                "//a[@href='https://fleetcart.envaysoft.com/en/admin/password/reset']")));
        Assert.assertTrue(forgotPW.isDisplayed());
        driver.close();
    }
}
