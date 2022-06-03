import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise5 {
    @Test
    public void exercise4() throws InterruptedException {
        //Step 1: Navigate to the URL:   https://www.seleniumeasy.com/test/table-pagination-demo.html  in Chrome browser
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/table-pagination-demo.html");

        driver.manage().window().maximize();
        String actualUrl = "https://demo.seleniumeasy.com/table-pagination-demo.html";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Looking for “Table with Pagination Example”
        WebElement text = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']//h2[text()=' Table with Pagination Example']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println("Step 2: Passed");

        //Step 3: Get the first row value of table and display value to the screen
        WebElement table = driver.findElement(By.id("myTable"));
        List<WebElement> lsTR = table.findElements(By.tagName("tr"));
        List<WebElement> lsTD = lsTR.get(1).findElements(By.tagName("td"));
        for (WebElement element : lsTD) {
            System.out.println(element.getText());
        }
        System.out.println("Step 3: Passed");

        driver.close();
    }
}
