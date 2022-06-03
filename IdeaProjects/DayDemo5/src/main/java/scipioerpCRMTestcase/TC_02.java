package scipioerpCRMTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {
    @Test
    public void verifyForgotPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/crm");

        //Step 1: Verify navigate to scipioerp login page
        driver.manage().window().maximize();
        String actualUrl = "https://ce.scipioerp.com/crm/control/main";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Click to Forgot Your Password link
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot Your Password"));
        Assert.assertTrue(forgotPassword.isDisplayed(),"Forgot Your Password button is not displayed");
        forgotPassword.click();
        Thread.sleep(3000);

        String actualUrl1 = "https://ce.scipioerp.com/crm/control/forgotPassword";
        String expectedUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1);

        //Verify whether the Forgot Your Password page is displayed exactly
        WebElement username = driver.findElement(By.id("field_id__1"));
        Assert.assertTrue(username.isDisplayed(),"Username is not displayed");
        WebElement goBackBtn = driver.findElement(By.xpath("//a[text()='Go Back']"));
        Assert.assertTrue(goBackBtn.isDisplayed(),"Go Back button is not displayed");
        WebElement getPasswordHintBtn = driver.findElement(By.id("field_id__2"));
        Assert.assertTrue(getPasswordHintBtn.isDisplayed(),"Get Password Hint button is not displayed");
        WebElement emailPassword = driver.findElement(By.id("field_id__3"));
        Assert.assertTrue(emailPassword.isDisplayed(),"Email Password button is not displayed");

        System.out.println("Step 2: Passed");
        System.out.println("TC_02: PASSED");
        driver.close();
    }
}
