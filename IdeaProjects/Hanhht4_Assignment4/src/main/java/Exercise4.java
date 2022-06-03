import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise4 {
    @Test
    public void exercise4() throws InterruptedException {
        //Step 1: Navigate to the URL:  https://www.seleniumeasy.com/test/basic-select-dropdown-demo.htm in Chrome browser
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        driver.manage().window().maximize();
        String actualUrl = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Looking for “Select List Demo”
        WebElement text = driver.findElement(By.xpath("//div[text()='Select List Demo']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println("Step 2: Passed");

        //Step 3: Select “Monday” in combobox
        WebElement combobox = driver.findElement(By.id("select-demo"));
        Select select = new Select(combobox);
        select.selectByValue("Monday");
        Thread.sleep(4000);
        System.out.println("Step 3: Passed");

        //Step 4: Verify message display
        WebElement message = driver.findElement(By.xpath("(//div[@class='panel panel-default'])[2]//p[@class='selected-value']"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("Step 4: Passed");

        driver.close();
    }
}
