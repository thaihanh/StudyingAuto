import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2 {
    @Test
    public void exercise2() throws InterruptedException {
        //Step 1: Navigate to the URL: https://www.seleniumeasy.com/test/basic-checkbox-demo.html in Chrome browser
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html");

        driver.manage().window().maximize();
        String actualUrl = "http://demo.seleniumeasy.com/basic-checkbox-demo.html";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Looking for “Single Checkbox Demo”
        WebElement singleCheckboxDemo = driver.findElement(By.xpath("//div[text()='Single Checkbox Demo']"));
        Assert.assertTrue(singleCheckboxDemo.isDisplayed());
        System.out.println("Step 2: Passed");

        //Step 3: Click “Click on this check box” check box
        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));
        if (!checkbox.isSelected()){
            checkbox.click();
        }
        Thread.sleep(4000);
        System.out.println("Step 3: Passed");
        //Step 4: Verify message display
        WebElement message = driver.findElement(By.id("txtAge"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("Step 4: Passed");

        driver.close();
    }
}
