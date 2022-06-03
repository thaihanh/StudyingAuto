package scipioerpCRMTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {
    @Test
    public void verifyLoginPage(){
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/crm");

        //Verify navigate to scipioerp login page
        driver.manage().window().maximize();
        String actualUrl = "https://ce.scipioerp.com/crm/control/main";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Navigate to scipioerp login page successfully");

        //Verify whether the login page is displayed exactly
        WebElement username = driver.findElement(By.id("field_id__1"));
        Assert.assertTrue(username.isDisplayed(),"Username is not displayed");
        WebElement password = driver.findElement(By.id("field_id__2"));
        Assert.assertTrue(password.isDisplayed(),"Password is not displayed");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type ='submit']"));
        Assert.assertTrue(loginBtn.isDisplayed(),"Login button is not displayed");
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot Your Password"));
        Assert.assertTrue(forgotPassword.isDisplayed(),"Forgot Your Password button is not displayed");

        System.out.println("TC_01: PASSED");
        driver.close();
    }
}
