package scipioerpCRMTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03 {
    @Test
    public void verifyHomePage(){
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
        Assert.assertEquals(actualTitle, expectedTitle,"Login failed");

        //Verify whether the page is displayed exactly
        //+ Menu left
        //+ Gross Sales chart
        //+ Best Selling Products chart
        //+ Registrations chart
        //+ Last Communication chart
        //+ List Marketing Campaign chart
        WebElement menuLeft = driver.findElement(By.id("menu_1"));
        Assert.assertTrue(menuLeft.isDisplayed(), "Menu Left is not displayed");
        WebElement grossSaleChart = driver.findElement(By.xpath("//h2[text()='Gross Sales (per day)']/.."));
        Assert.assertTrue(grossSaleChart.isDisplayed(), "Gross Sales chart is not displayed");
        WebElement bestSellingProductsChart = driver.findElement(By.xpath("//h2[text()='Best Selling Products']/.."));
        Assert.assertTrue(bestSellingProductsChart.isDisplayed(), "Best Selling Products chart is not displayed");
        WebElement registrationsChart = driver.findElement(By.xpath("//h2[text()='Registrations']/.."));
        Assert.assertTrue(registrationsChart.isDisplayed(), "Registrations chart is not displayed");
        WebElement lastCommunicationChart = driver.findElement(By.xpath("//h2[text()='Last Communication']/.."));
        Assert.assertTrue(lastCommunicationChart.isDisplayed(), "Last Communication chart is not displayed");
        WebElement listMarketingCampaignChart = driver.findElement(By.xpath("//h2[text()='List Marketing Campaign']/.."));
        Assert.assertTrue(listMarketingCampaignChart.isDisplayed(), "List Marketing Campaign chart is not displayed");

        System.out.println("Step 2: Passed");
        System.out.println("TC_03: PASSED");
        driver.close();
    }
}
