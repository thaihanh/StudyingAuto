package practiceTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_02 {
    @Test
    public void verifyWarehousesSearchResults(){
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

        WebElement results = driver.findElement(By.xpath("//div[@class='row pagination-area']//following-sibling::div"));
        String actualResult = results.getText();
        String expectedResult = "1 - 1 of 1";
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("The Search Results displayed 1 record");

        WebElement table = driver.findElement(By.xpath("(//table)[2]"));
        List<WebElement> lsTR = table.findElements(By.tagName("tr"));
        for (WebElement element : lsTR) {
            List<WebElement> lsTD = element.findElements(By.tagName("td"));
            for (WebElement th : lsTD) {
                System.out.print(th.getText() + ", ");
            }
        }
        System.out.println();
        WebElement col1 = driver.findElement(By.xpath("(//table)[2]//td[1]"));
        String actualCol1 = col1.getText();
        String expectedCol1 = "ScipioShopWarehouse";
        Assert.assertEquals(actualCol1, expectedCol1);

        WebElement col2 = driver.findElement(By.xpath("(//table)[2]//td[2]"));
        String actualCol2 = col2.getText();
        String expectedCol2 = "Web Store Warehouse";
        Assert.assertEquals(actualCol2, expectedCol2);

        WebElement col3 = driver.findElement(By.xpath("(//table)[2]//td[3]"));
        String actualCol3 = col3.getText();
        String expectedCol3 = "Warehouse";
        Assert.assertEquals(actualCol3, expectedCol3);

        WebElement col4 = driver.findElement(By.xpath("(//table)[2]//td[4]"));
        String actualCol4 = col4.getText();
        String expectedCol4 = "Company";
        Assert.assertEquals(actualCol4, expectedCol4);

        WebElement col5 = driver.findElement(By.xpath("(//table)[2]//td[5]"));
        String actualCol5 = col5.getText();
        String expectedCol5 = " ";
        Assert.assertEquals(actualCol5, expectedCol5);

        WebElement col6 = driver.findElement(By.xpath("(//table)[2]//td[6]"));
        String actualCol6 = col6.getText();
        String expectedCol6 = "Warehouse exclusively for the Web Store";
        Assert.assertEquals(actualCol6, expectedCol6);

        System.out.println("Step 4: PASSED");
    }
}
