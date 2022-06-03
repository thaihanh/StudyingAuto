package practiceTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03 {
    @Test
    public void verifyCreateNewWarehouses() throws InterruptedException {
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

        WebElement createNewWarehouseBtn = driver.findElement(By.linkText("Create New Warehouse"));
        createNewWarehouseBtn.click();
        String actualTitle2 = "SCIPIO - Warehouse Manager: New Warehouse";
        String expectedTitle2 = driver.getTitle();
        Assert.assertEquals(actualTitle2, expectedTitle2);
        System.out.println("Step 4: PASSED");

//        5. Input value to the required field.
//        - Warehouse Type ID: Floor.
//        - Owner: ACCOUNTING
//        - Default Weight Unit: Gram(g)
//        - Default Inventory Item Type: Serialized.
//        - Name : Test_demo (Random value)
//        - Area Unit: Square Millimeter (mm2)
//        - Product Description: Test Automation

        WebElement warehouseTypeID = driver.findElement(By.id("field_id__1"));
        Select selectField1 = new Select(warehouseTypeID);
        selectField1.selectByValue("FLOOR");
        Thread.sleep(3000);

        WebElement owner = driver.findElement(By.id("ownerPartyId_ownerPartyId"));
        owner.sendKeys("ACCOUNTING");

        WebElement defaultWeightUnit = driver.findElement(By.id("field_id__4"));
        Select selectField4 = new Select(defaultWeightUnit);
        selectField4.selectByValue("WT_g");
        Thread.sleep(3000);

        WebElement defaultInventoryItemType = driver.findElement(By.id("field_id__5"));
        Select selectField5 = new Select(defaultInventoryItemType);
        selectField5.selectByValue("SERIALIZED_INV_ITEM");
        Thread.sleep(3000);

        WebElement name = driver.findElement(By.id("field_id__6"));
        name.sendKeys("Test_demo (Random value)");

        WebElement areaUnit = driver.findElement(By.id("field_id__8"));
        Select selectField8 = new Select(areaUnit);
        selectField8.selectByValue("AREA_mm2");
        Thread.sleep(3000);

        WebElement productDescription = driver.findElement(By.id("field_id__9"));
        productDescription.sendKeys("Test Automation");
        System.out.println("Step 5: PASSED");

        WebElement saveBtn = driver.findElement(By.id("field_id__11"));
        saveBtn.click();

        WebElement messSuccess = driver.findElement(By.xpath("//div[@id='main-alert']//li[text()='Operation has been executed successfully']"));
        Assert.assertTrue(messSuccess.isDisplayed());
        System.out.println("The message displayed: Operation has been executed successfully");
        System.out.println("Step 6: PASSED");
    }
}
