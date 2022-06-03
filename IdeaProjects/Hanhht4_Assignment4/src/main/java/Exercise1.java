import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 {
    @Test
    public void exercise1() throws InterruptedException {
        //Step 1: Navigate to the URL: https://www.seleniumeasy.com/test/basic-first-form-demo.html in Chrome browser

        //em thử các link trên tất cả các exercise đều hiển thị "Page not found" nên em thay link khác tương tự để test ạ
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        driver.manage().window().maximize();
        String actualUrl = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Input “Automation Tester”
        WebElement enterMsgInput = driver.findElement(By.id("user-message"));
        enterMsgInput.sendKeys("Automation Tester");
        System.out.println("Step 2: Passed");

        //Step 3: Click “Show Message” button
        WebElement showMsgBtn = driver.findElement(By.xpath("//form[@id='get-input']//button[text()='Show Message']"));
        showMsgBtn.click();
        Thread.sleep(3000);
        System.out.println("Step 3: Passed");

        //Step 4: Verify message display
        WebElement message = driver.findElement(By.xpath("//label[text()='Your Message: ']//parent::div"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("Step 4: Passed");

        driver.close();
    }
}
