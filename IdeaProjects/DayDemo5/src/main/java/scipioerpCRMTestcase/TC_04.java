package scipioerpCRMTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04 {
    @Test
    public void verifyMarketingCampaignPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/crm");

        //Step 1: Verify navigate to scipioerp login page
        driver.manage().window().maximize();
        String actualUrl = "https://ce.scipioerp.com/crm/control/main";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Check login
        WebElement username = driver.findElement(By.id("field_id__1"));
        WebElement password = driver.findElement(By.id("field_id__2"));
        username.sendKeys("admin");
        password.sendKeys("scipio");
        password.submit();

        String actualTitle = "SCIPIO - CRM: Marketing Manager Application";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Login failed");
        System.out.println("Step 2: Passed");

        //3. On left menu click to Marketing
        WebElement marketingMenuItem = driver.findElement(By.linkText("Marketing"));
        marketingMenuItem.click();
        Thread.sleep(3000);
        String actualTitle1 = "SCIPIO - CRM: Marketing Campaign";
        String expectedTitle1 = driver.getTitle();
        Assert.assertEquals(actualTitle1, expectedTitle1, "Navigate failed");

        //Verify whether the Marketing Campaign page is displayed exactly:
        //+ Campaign ID
        //+ Campaign Name
        //+ Parent Campaign ID
        //+ Status
        //+ Find button

        WebElement campaignID = driver.findElement(By.id("field_id__1"));
        Assert.assertTrue(campaignID.isDisplayed(), "Campaign ID is not displayed");
        WebElement campaignName = driver.findElement(By.id("field_id__2"));
        Assert.assertTrue(campaignName.isDisplayed(), "Campaign Name is not displayed");
        WebElement parentCampaignID = driver.findElement(By.id("field_id__3"));
        Assert.assertTrue(parentCampaignID.isDisplayed(), "Parent Campaign ID is not displayed");
        WebElement status = driver.findElement(By.id("field_id__4"));
        Assert.assertTrue(status.isDisplayed(), "Status is not displayed");
        WebElement findBtn = driver.findElement(By.id("field_id__5"));
        Assert.assertTrue(findBtn.isDisplayed(), "Find button is not displayed");

        System.out.println("Step 3: Passed");
        System.out.println("TC_04: PASSED");
        driver.close();
    }
}
