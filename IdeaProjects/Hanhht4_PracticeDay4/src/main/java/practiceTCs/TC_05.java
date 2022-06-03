package practiceTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05 {
    @Test
    public void verifyCreateNewInventoryPage() throws InterruptedException {
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

        WebElement inventoryMenuItem = driver.findElement(By.linkText("Inventory"));
        inventoryMenuItem.click();

        String actualTitle2 = "SCIPIO - Warehouse Manager: Inventory Items ScipioShopWarehouse";
        String expectedTitle2 = driver.getTitle();
        Assert.assertEquals(actualTitle2, expectedTitle2);
        System.out.println("Step 6: PASSED");

        WebElement newInventoryItemBtn = driver.findElement(By.linkText("New Inventory Item"));
        newInventoryItemBtn.click();
        Thread.sleep(3000);
        String actualTitle3 = "SCIPIO - Warehouse Manager: New Inventory Item ScipioShopWarehouse";
        String expectedTitle3 = driver.getTitle();
        Assert.assertEquals(actualTitle3, expectedTitle3);
        System.out.println("Step 7: PASSED");

//        8. Input value to the required field:
//        - InventoryItem Type ID: Serialized
//        - Product ID: VH-9943
//        - User ID: ACCOUNTING
//        - Owner Party ID: ACCOUNTING
//        - Status: Available
//        - Date Time Received: 2021-04-29 22:31:18.982
//        - Date Time Manufactured: 2021-04-28 22:31:22.380
//        - Expire Date: 2021-04-16 22:31:24.617.
//        - Warehouse ID: Web Store Warehouse

        WebElement inventoryItemTypeID = driver.findElement(By.id("EditInventoryItem_inventoryItemTypeId"));
        Select select = new Select(inventoryItemTypeID);
        select.selectByValue("SERIALIZED_INV_ITEM");
        WebElement productID = driver.findElement(By.id("EditInventoryItem_productId_EditInventoryItem_productId"));
        productID.sendKeys("VH-9943");
        WebElement userID = driver.findElement(By.id("EditInventoryItem_partyId_EditInventoryItem_partyId"));
        userID.sendKeys("ACCOUNTING");
        WebElement ownerPartyID = driver.findElement(By.id("EditInventoryItem_ownerPartyId_EditInventoryItem_ownerPartyId"));
        ownerPartyID.sendKeys("ACCOUNTING");
        WebElement status = driver.findElement(By.id("EditInventoryItem_statusId"));
        Select select1 = new Select(status);
        select1.selectByValue("INV_AVAILABLE");
        WebElement dateTimeReceived = driver.findElement(By.id("EditInventoryItem_datetimeReceived_i18n"));
        dateTimeReceived.sendKeys("2021-04-29 22:31:18.982");
        WebElement dateTimeManufactured = driver.findElement(By.id("EditInventoryItem_datetimeManufactured_i18n"));
        dateTimeManufactured.sendKeys("2021-04-28 22:31:22.380");
        WebElement expireDate = driver.findElement(By.id("EditInventoryItem_expireDate_i18n"));
        expireDate.sendKeys("2021-04-16 22:31:24.617");
        WebElement warehouseIdSelect = driver.findElement(By.id("EditInventoryItem_facilityId"));
        Select select2 = new Select(warehouseIdSelect);
        select2.selectByValue("ScipioShopWarehouse");
        WebElement warehouseLocation = driver.findElement(By.id("EditInventoryItem_locationSeqId_EditInventoryItem_locationSeqId"));
        warehouseLocation.sendKeys("TLTLTLLL01");
        System.out.println("Step 8: PASSED");

        WebElement createBtn = driver.findElement(By.id("EditInventoryItem_submit"));
        createBtn.click();
        Thread.sleep(3000);

        WebElement successMsg = driver.findElement(By.xpath("//div[@class='alert alert-info']//" +
                "li[text()='Exception thrown while creating the \"inventoryItem\" GenericValue']"));
        //Làm theo step của TC nhưng tạo Warehouse thành công, không lỗi như expect của test case
        Assert.assertTrue(successMsg.isDisplayed());
        System.out.println("Step 9: PASSED");
    }
}
