import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3 {
    @Test
    public void exercise3() throws InterruptedException {
        //Step 1: Hit the URL: https://www.booking.com in Chrome browser.
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        driver.manage().window().maximize();
        String actualUrl = "https://www.booking.com/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Navigate to page successfully");

        //Step 2. Click Register on top page
        WebElement registerBtn = driver.findElement(By.linkText("Register"));
        registerBtn.click();
        Thread.sleep(3000);

        String actualTitle = "Booking.com";
        String expectedTitle = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Navigate to Register page successfully");
        //Step 3. Look for Register tab and write the selectors of element by Id, Name, Class, XPath as below:
        // Email Address textbox
        WebElement emailAddressTxt = driver.findElement(By.id("username"));
        Assert.assertTrue(emailAddressTxt.isDisplayed());
        // Get started button
        WebElement continueWithEmailBtn = driver.findElement(By.xpath("//span[text()='Continue with email']//.."));
        Assert.assertTrue(emailAddressTxt.isDisplayed());
        // Sign up with Facebook
        WebElement signUpWithFbBtn = driver.findElement(By.xpath("//div[@class='access-panel__social-buttons']//a[1]"));
        signUpWithFbBtn.click();
        driver.close();
    }
}
