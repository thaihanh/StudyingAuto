package practiceTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class TC_01 {
    @Test
    public void verifyWarehousesPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ce.scipioerp.com/facility/");

        //Step1.1: Verify navigate to scipioerp login page
        driver.manage().window().maximize();
        String actualUrl = "https://ce.scipioerp.com/facility/control/main";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Navigate to scipioerp login page successfully");

        //Step1.2: Verify whether the login page is displayed exactly
        WebElement username = driver.findElement(By.id("field_id__1"));
        assertTrue(username.isDisplayed());
        WebElement password = driver.findElement(By.id("field_id__2"));
        assertTrue(password.isDisplayed());
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type ='submit']"));
        assertTrue(loginBtn.isDisplayed());
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot Your Password"));
        assertTrue(forgotPassword.isDisplayed());

        System.out.println("Step 1: PASSED");
//        if (username.isDisplayed() && password.isDisplayed() && loginBtn.isDisplayed() && forgotPassword.isDisplayed()) {
//            System.out.println("The login page is displayed exactly");
//        } else {
//            System.out.println("The login page is displayed wrong");
//        }

        //Step 2: Check login
        username.sendKeys("admin");
        password.sendKeys("scipio");
        password.submit();

        String actualTitle = "SCIPIO - Warehouse Manager: Warehouse Manager";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Step 2: PASSED");

        //Step 3: Click to Warehouses menu-item
        WebElement warehousesMenuItem = driver.findElement(By.linkText("Warehouses"));
        warehousesMenuItem.click();

        WebElement createNewWarehouseBtn = driver.findElement(By.linkText("Create New Warehouse"));
        assertTrue(createNewWarehouseBtn.isDisplayed());

        WebElement searchOptions = driver.findElement(By.xpath("//h2[text()='Search Options']//.."));
        assertTrue(searchOptions.isDisplayed());
        WebElement warehouseId = driver.findElement(By.xpath("//input[@class='form-control' and @name='facilityId']"));
        assertTrue(warehouseId.isDisplayed());
        WebElement parentWarehouseID = driver.findElement(By.xpath("//input[@class='form-control' and @name='facilityName']"));
        assertTrue(parentWarehouseID.isDisplayed());
        WebElement warehouseTypeID = driver.findElement(By.id("lookupFacility_facilityTypeId"));
        assertTrue(warehouseTypeID.isDisplayed());
        WebElement findBtn = driver.findElement(By.id("lookupFacility_submitAction"));
        assertTrue(findBtn.isDisplayed());

        WebElement searchResults = driver.findElement(By.xpath("//h2[text()='Search Results']//.."));
        assertTrue(searchResults.isDisplayed());

//        WebElement table = driver.findElement(By.xpath("(//table)[1]"));
//        List<WebElement> lsTR = table.findElements(By.tagName("tr"));
//        for (WebElement element : lsTR) {
//            List<WebElement> lsTH = element.findElements(By.tagName("th"));
//            for (WebElement th : lsTH) {
//                System.out.print(th.getText() + ", ");
//            }
//        }

        WebElement headCol1 = driver.findElement(By.xpath("(//table)[1]//th[1]"));
        String actualCol1 = headCol1.getText();
        String expectedCol1 = "Warehouse ID";
        Assert.assertEquals(actualCol1, expectedCol1);

        WebElement headCol2 = driver.findElement(By.xpath("(//table)[1]//th[2]"));
        String actualCol2 = headCol2.getText();
        String expectedCol2 = "Warehouse Name";
        Assert.assertEquals(actualCol2, expectedCol2);

        WebElement headCol3 = driver.findElement(By.xpath("(//table)[1]//th[3]"));
        String actualCol3 = headCol3.getText();
        String expectedCol3 = "Warehouse Type";
        Assert.assertEquals(actualCol3, expectedCol3);

        WebElement headCol4 = driver.findElement(By.xpath("(//table)[1]//th[4]"));
        String actualCol4 = headCol4.getText();
        String expectedCol4 = "Owner";
        Assert.assertEquals(actualCol4, expectedCol4);

        WebElement headCol5 = driver.findElement(By.xpath("(//table)[1]//th[5]"));
        String actualCol5 = headCol5.getText();
        String expectedCol5 = "Area";
        Assert.assertEquals(actualCol5, expectedCol5);

        WebElement headCol6 = driver.findElement(By.xpath("(//table)[1]//th[6]"));
        String actualCol6 = headCol6.getText();
        String expectedCol6 = "Description";
        Assert.assertEquals(actualCol6, expectedCol6);

        System.out.println("Step 3: PASSED");

        driver.close();
    }
}
