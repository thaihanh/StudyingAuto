package practiceTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class TC_04 {
    @Test
    public void verifyInventoryPage(){
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

//        6. The Inventory page displayed with some field as belows
//        - New Inventory Item
//        - Warehouse ID
//        - Date Time Received
//        - Product ID
//        - Internal Name
//        - Inventory Item ID
//        - Status
//        - Serial Number
//        - Soft Identifier
//        - Manufacturer User ID
//        - Lot ID
//        - Find button

        WebElement newInventoryItemBtn = driver.findElement(By.linkText("New Inventory Item"));
        assertTrue(newInventoryItemBtn.isDisplayed());
        WebElement warehouseID = driver.findElement(By.id("SearchInventoryItemsParams_facilityId"));
        assertTrue(warehouseID.isDisplayed());
        WebElement dateTimeReceived = driver.findElement(By.id("field_id_4_1_i18n"));
        assertTrue(dateTimeReceived.isDisplayed());
        WebElement productID = driver.findElement(By.xpath("//input[@name=\"productId\"]"));
        assertTrue(productID.isDisplayed());
        WebElement internalName = driver.findElement(By.xpath("//input[@name=\"internalName\"]"));
        assertTrue(internalName.isDisplayed());
        WebElement inventoryItemId = driver.findElement(By.xpath("//input[@name=\"inventoryItemId\"]"));
        assertTrue(inventoryItemId.isDisplayed());
        WebElement status = driver.findElement(By.id("SearchInventoryItemsParams_statusId"));
        assertTrue(status.isDisplayed());
        WebElement serialNo = driver.findElement(By.xpath("//input[@name=\"serialNumber\"]"));
        assertTrue(serialNo.isDisplayed());
        WebElement softIdentifier = driver.findElement(By.id("SearchInventoryItemsParams_softIdentifier"));
        assertTrue(softIdentifier.isDisplayed());
        WebElement manufacturerUserId = driver.findElement(By.id("SearchInventoryItemsParams_partyId_SearchInventoryItemsParams_partyId"));
        assertTrue(manufacturerUserId.isDisplayed());
        WebElement lotId = driver.findElement(By.id("SearchInventoryItemsParams_lotId"));
        assertTrue(lotId.isDisplayed());
        WebElement findInventoryBtn = driver.findElement(By.id("SearchInventoryItemsParams_submitAction"));
        assertTrue(findInventoryBtn.isDisplayed());
        System.out.println("Step 6: PASSED");





    }
}
