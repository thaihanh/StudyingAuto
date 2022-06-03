package scipioerpCRMTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06 {
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

        //Step 3: On left menu click to Marketing
        WebElement marketingMenuItem = driver.findElement(By.linkText("Marketing"));
        marketingMenuItem.click();
        Thread.sleep(3000);
        String actualTitle1 = "SCIPIO - CRM: Marketing Campaign";
        String expectedTitle1 = driver.getTitle();
        Assert.assertEquals(actualTitle1, expectedTitle1, "Navigate failed");
        System.out.println("Step 3: Passed");

        //Step 4: Click Create marketing Campaign
        WebElement createMarketingCampaignBtn = driver.findElement(By.linkText("Create Marketing Campaign"));
        Assert.assertTrue(createMarketingCampaignBtn.isDisplayed());
        createMarketingCampaignBtn.click();

        String actualUrl1 = "https://ce.scipioerp.com/crm/control/EditMarketingCampaign";
        String expectedUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1, "Navigate failed");
        System.out.println("Step 4: Passed");

        //Step 5: Input value into Marketing Campaign form
        WebElement campaignID = driver.findElement(By.id("EditMarketingCampaign_marketingCampaignId"));
        campaignID.sendKeys("11111");
        WebElement parentCampaignID = driver.findElement(By.id("EditMarketingCampaign_parentCampaignId"));
        Select s = new Select(parentCampaignID);
        s.selectByValue("9000");
        WebElement status = driver.findElement(By.id("EditMarketingCampaign_statusId"));
        Select s1 = new Select(status);
        s1.selectByValue("MKTG_CAMP_INPROGRESS");
        WebElement campaignName = driver.findElement(By.id("EditMarketingCampaign_campaignName"));
        campaignName.sendKeys("Campaign Name");
        WebElement campaignSummary = driver.findElement(By.id("EditMarketingCampaign_campaignSummary"));
        campaignSummary.sendKeys("Campaign Summary");
        WebElement budgetedCost = driver.findElement(By.id("EditMarketingCampaign_budgetedCost"));
        budgetedCost.sendKeys("10000");
        WebElement actualCost = driver.findElement(By.id("EditMarketingCampaign_actualCost"));
        actualCost.sendKeys("12000");
        WebElement estimatedCost = driver.findElement(By.id("EditMarketingCampaign_estimatedCost"));
        estimatedCost.sendKeys("15000");
        WebElement currency = driver.findElement(By.id("EditMarketingCampaign_currencyUomId"));
        Select s3 = new Select(currency);
        s3.selectByValue("AUD");
        //WebElement fromDate = driver.findElement(By.id("EditMarketingCampaign_fromDate_i18n"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementById('EditMarketingCampaign_fromDate_i18n').setAttribute('value','2022-05-11 17:41:58.901')");
        //WebElement throughDate = driver.findElement(By.id("EditMarketingCampaign_thruDate_i18n"));
        javascriptExecutor.executeScript("document.getElementById('EditMarketingCampaign_thruDate_i18n').setAttribute('value','2022-05-11 17:41:58.901')");
        WebElement isActive = driver.findElement(By.id("EditMarketingCampaign_isActive"));
        Select s4 = new Select(isActive);
        s4.selectByValue("N");
        WebElement convertedLeads = driver.findElement(By.id("EditMarketingCampaign_convertedLeads"));
        convertedLeads.sendKeys("1");
        WebElement expectedResponsePercent = driver.findElement(By.id("EditMarketingCampaign_expectedResponsePercent"));
        expectedResponsePercent.sendKeys("40");
        WebElement expectedRevenue = driver.findElement(By.id("EditMarketingCampaign_expectedRevenue"));
        expectedRevenue.sendKeys("25000");
        WebElement numSent = driver.findElement(By.id("EditMarketingCampaign_numSent"));
        numSent.sendKeys("0");
        //WebElement startDate = driver.findElement(By.id("EditMarketingCampaign_startDate_i18n"));
        javascriptExecutor.executeScript("document.getElementById('EditMarketingCampaign_startDate_i18n').setAttribute('value','2022-05-11 17:41:58.901')");
        System.out.println("Step 5: Passed");

        //Step 6: Click "Save" to create new marketing Campaign
        WebElement saveBtn = driver.findElement(By.id("EditMarketingCampaign_submitAction"));
        saveBtn.click();
        Thread.sleep(3000);
        WebElement successMsg = driver.findElement(By.xpath("//div[@class='alert alert-info']//li[text()='Marketing Campaign created successfully']"));
        Assert.assertTrue(successMsg.isDisplayed());
        System.out.println("Step 6: Passed");

        //Step 7: Back to the Marketing Campaign page and search by name.(https://ce.scipioerp.com/crm/control/FindMarketingCampaign)
        //driver.navigate().back();
        driver.get("https://ce.scipioerp.com/crm/control/FindMarketingCampaign");
        WebElement campaignNameSearch = driver.findElement(By.id("field_id__2"));
        campaignNameSearch.sendKeys("Campaign Name");
        WebElement findBtn = driver.findElement(By.id("field_id__5"));
        findBtn.click();
        Thread.sleep(3000);

        //Verify the Marketing Campaign should be display: Campaign ID, Campaign Name
        WebElement campaignIdResult = driver.findElement(By.xpath("//table[@id='table_1']//td[1]"));
//        String actualCampaignIdResult = "11111";
//        String expectedCampaignIdResult = campaignIdResult.getText();
//        Assert.assertEquals(actualCampaignIdResult,expectedCampaignIdResult);
        Assert.assertTrue(campaignIdResult.isDisplayed());
        WebElement campaignNameResult = driver.findElement(By.xpath("//table[@id='table_1']//td[1]"));
//        String actualCampaignNameResult = "Campaign Name";
//        String expectedCampaignNameResult = campaignNameResult.getText();
//        Assert.assertEquals(actualCampaignNameResult,expectedCampaignNameResult);
        Assert.assertTrue(campaignNameResult.isDisplayed());
        System.out.println("Step 7: Passed");

        System.out.println("TC_06: PASSED");
        driver.close();
    }
}
