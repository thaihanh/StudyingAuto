import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Exercise1 {
    @Test
    public void test() throws InterruptedException {
        //Step 1: Open Chrome browser
        //Step 2: Maximize the browser window
        //Step 3: Navigate to http://demo.guru99.com/test/drag_drop.html webpage
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();


        //Step 4: Write a code to perform drag and drop operation from source to target
        Actions actions = new Actions(driver);
        WebElement fourth = driver.findElement(By.id("fourth"));
        WebElement li = driver.findElement(By.xpath("(//li[@class=\"placeholder\"])[2]"));
        Thread.sleep(2000);
        actions.dragAndDrop(fourth,li).perform();

        Thread.sleep(4000);
        driver.close();
    }
}
