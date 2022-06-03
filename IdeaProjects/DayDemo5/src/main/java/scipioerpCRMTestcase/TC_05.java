package scipioerpCRMTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05 {
    @Test
    public void verifyCreateMarketingCampaignPage() throws InterruptedException {
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
        System.out.println("Step 3: Passed");

        //4. Click Create marketing Campaign
        WebElement createMarketingCampaignBtn = driver.findElement(By.linkText("Create Marketing Campaign"));
        Assert.assertTrue(createMarketingCampaignBtn.isDisplayed());
        createMarketingCampaignBtn.click();

        String actualUrl1 = "https://ce.scipioerp.com/crm/control/EditMarketingCampaign";
        String expectedUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1, "Navigate failed");

        //Verify whether the Create marketing Campaign page is displayed exactly:

        WebElement campaignID = driver.findElement(By.id("EditMarketingCampaign_marketingCampaignId"));
        Assert.assertTrue(campaignID.isDisplayed(), "Campaign ID is not displayed");
        WebElement parentCampaignID = driver.findElement(By.id("EditMarketingCampaign_parentCampaignId"));
        Assert.assertTrue(parentCampaignID.isDisplayed(), "Parent Campaign ID is not displayed");
        WebElement status = driver.findElement(By.id("EditMarketingCampaign_statusId"));
        Assert.assertTrue(status.isDisplayed(), "Status is not displayed");
        WebElement campaignName = driver.findElement(By.id("EditMarketingCampaign_campaignName"));
        Assert.assertTrue(campaignName.isDisplayed(), "Campaign Name is not displayed");
        WebElement campaignSummary = driver.findElement(By.id("EditMarketingCampaign_campaignSummary"));
        Assert.assertTrue(campaignSummary.isDisplayed(), "Campaign Summary is not displayed");
        WebElement budgetedCost = driver.findElement(By.id("EditMarketingCampaign_budgetedCost"));
        Assert.assertTrue(budgetedCost.isDisplayed(), "Budgeted Cost is not displayed");
        WebElement actualCost = driver.findElement(By.id("EditMarketingCampaign_actualCost"));
        Assert.assertTrue(actualCost.isDisplayed(), "Actual Cost is not displayed");
        WebElement estimatedCost = driver.findElement(By.id("EditMarketingCampaign_estimatedCost"));
        Assert.assertTrue(estimatedCost.isDisplayed(), "Estimated cost is not displayed");
        WebElement currency = driver.findElement(By.id("EditMarketingCampaign_currencyUomId"));
        Assert.assertTrue(currency.isDisplayed(), "Currency is not displayed");
        WebElement fromDate = driver.findElement(By.id("EditMarketingCampaign_fromDate_i18n"));
        Assert.assertTrue(fromDate.isDisplayed(), "From Date is not displayed");
        WebElement throughDate = driver.findElement(By.id("EditMarketingCampaign_thruDate_i18n"));
        Assert.assertTrue(throughDate.isDisplayed(), "Through Date is not displayed");
        WebElement isActive = driver.findElement(By.id("EditMarketingCampaign_isActive"));
        Assert.assertTrue(isActive.isDisplayed(), "Is Active is not displayed");
        WebElement convertedLeads = driver.findElement(By.id("EditMarketingCampaign_convertedLeads"));
        Assert.assertTrue(convertedLeads.isDisplayed(), "Converted Leads is not displayed");
        WebElement expectedResponsePercent = driver.findElement(By.id("EditMarketingCampaign_expectedResponsePercent"));
        Assert.assertTrue(expectedResponsePercent.isDisplayed(), "Expected Response Percent is not displayed");
        WebElement expectedRevenue = driver.findElement(By.id("EditMarketingCampaign_expectedRevenue"));
        Assert.assertTrue(expectedRevenue.isDisplayed(), "Expected Revenue is not displayed");
        WebElement numSent = driver.findElement(By.id("EditMarketingCampaign_numSent"));
        Assert.assertTrue(numSent.isDisplayed(), "Num Sent is not displayed");
        WebElement startDate = driver.findElement(By.id("EditMarketingCampaign_startDate_i18n"));
        Assert.assertTrue(startDate.isDisplayed(), "Start Date is not displayed");
        WebElement saveBtn = driver.findElement(By.id("EditMarketingCampaign_submitAction"));
        Assert.assertTrue(saveBtn.isDisplayed(), "Save button is not displayed");
        System.out.println("Step 4: Passed");

        System.out.println("TC_05: PASSED");
        driver.close();
    }
}
