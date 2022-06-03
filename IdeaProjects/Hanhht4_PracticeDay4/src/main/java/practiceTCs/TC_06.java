package practiceTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TC_06 {
    @Test
    public void verifySettingsPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/facility/");

        driver.manage().window().maximize();
        String actualUrl = "https://ce.scipioerp.com/facility/control/main";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: PASSED");

        WebElement username = driver.findElement(By.id("field_id__1"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("field_id__2"));
        password.sendKeys("scipio");
        password.submit();
        String actualTitle = "SCIPIO - Warehouse Manager: Warehouse Manager";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Step 2: PASSED");

        WebElement warehousesMenuItem = driver.findElement(By.linkText("Warehouses"));
        warehousesMenuItem.click();
        String actualTitle1 = "SCIPIO - Warehouse Manager: Find Warehouses";
        String expectedTitle1 = driver.getTitle();
        Assert.assertEquals(actualTitle1, expectedTitle1);
        System.out.println("Step 3: PASSED");

        WebElement warehouseId = driver.findElement(By.xpath("//input[@class='form-control' and @name='facilityId']"));
        warehouseId.sendKeys("ScipioShopWarehouse");
        WebElement findBtn = driver.findElement(By.id("lookupFacility_submitAction"));
        findBtn.click();
        System.out.println("Step 4: PASSED");

        WebElement detailsLink = driver.findElement(By.xpath("(//table)[2]//td[1]"));
        detailsLink.click();

        String actualUrl1 = "https://ce.scipioerp.com/facility/control/EditFacility?facilityId=ScipioShopWarehouse";
        String expectedUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1, actualUrl1);
        System.out.println("Step 5: PASSED");

        WebElement settingsMenuItem = driver.findElement(By.linkText("Settings"));
        settingsMenuItem.click();
        String actualTitle2 = "SCIPIO - Warehouse Manager: Contact Information ScipioShopWarehouse";
        String expectedTitle2 = driver.getTitle();
        Assert.assertEquals(actualTitle2, expectedTitle2);
        System.out.println("Step 6: PASSED");

        WebElement contactInformationMenuItem = driver.findElement(By.linkText("Contact Information"));
        contactInformationMenuItem.click();
        String actualTitle3 = "SCIPIO - Warehouse Manager: Contact Information ScipioShopWarehouse";
        String expectedTitle3 = driver.getTitle();
        Assert.assertEquals(actualTitle3, expectedTitle3);
        System.out.println("Step 7: PASSED");

        WebElement newContactInformationBtn = driver.findElement(By.linkText("New Contact Information"));
        newContactInformationBtn.click();
        String actualTitle4 = "SCIPIO - Warehouse Manager: New Warehouse Contact Mechanism for Web Store Warehouse [ScipioShopWarehouse]";
        String expectedTitle4 = driver.getTitle();
        Assert.assertEquals(actualTitle4, expectedTitle4);

        WebElement selectContactType = driver.findElement(By.id("field_id__1"));
        Assert.assertTrue(selectContactType.isDisplayed());
        WebElement createBtn = driver.findElement(By.id("field_id__2"));
        Assert.assertTrue(createBtn.isDisplayed());
        System.out.println("Step 8: PASSED");

        Select s = new Select(selectContactType);
        s.selectByValue("POSTAL_ADDRESS");
        System.out.println("Step 9: PASSED");

        createBtn.click();
        Thread.sleep(3000);
        String actualUrl2 = "https://ce.scipioerp.com/facility/control/EditContactMech";
        String expectedUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl2, actualUrl2);

//        10. The page will be displayed:
//            - Contact Purposes
//            - To Name
//            - Attention Name
//            - Address Line 1
//            - Address Line 2
//            - City
//            - State/Province
//            - Zip/Postal Code
//            - Country
        WebElement contactPurposes = driver.findElement(By.id("field_id__1"));
        assertTrue(contactPurposes.isDisplayed());
        WebElement toName = driver.findElement(By.id("field_id__2"));
        assertTrue(toName.isDisplayed());
        WebElement attentionName = driver.findElement(By.id("field_id__3"));
        assertTrue(attentionName.isDisplayed());
        WebElement addressLine1 = driver.findElement(By.id("field_id__4"));
        assertTrue(addressLine1.isDisplayed());
        WebElement addressLine2 = driver.findElement(By.id("field_id__5"));
        assertTrue(addressLine2.isDisplayed());
        WebElement city = driver.findElement(By.id("field_id__6"));
        assertTrue(city.isDisplayed());
        WebElement stateProvince = driver.findElement(By.id("editcontactmechform_stateProvinceGeoId"));
        assertTrue(stateProvince.isDisplayed());
        WebElement zipPostalCode = driver.findElement(By.id("field_id__8"));
        assertTrue(zipPostalCode.isDisplayed());
        WebElement newInventoryItemBtn = driver.findElement(By.id("editcontactmechform_countryGeoId"));
        assertTrue(newInventoryItemBtn.isDisplayed());
        System.out.println("Step 10: PASSED");

        Select s2 = new Select(contactPurposes);
        s2.selectByValue("BILLING_LOCATION");
        toName.sendKeys("To Name test");
        attentionName.sendKeys("Attention Name test");
        addressLine1.sendKeys("Address Line 1 test");
        addressLine2.sendKeys("Address Line 2 test");
        city.sendKeys("City test");
        Select s3 = new Select(stateProvince);
        s3.selectByValue("AA");
        zipPostalCode.sendKeys("12345");

        WebElement saveBtn = driver.findElement(By.id("field_id__10"));
        saveBtn.click();
        Thread.sleep(3000);

        WebElement successMsg = driver.findElement(By.xpath("//div[@class='alert alert-info']//li[text()='Contact Mechanism successfully created.']"));
        Assert.assertTrue(successMsg.isDisplayed());
        System.out.println("Step 11: PASSED");
    }
}
