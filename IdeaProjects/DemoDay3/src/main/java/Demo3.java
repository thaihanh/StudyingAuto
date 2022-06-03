import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Demo3 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fleetcart.envaysoft.com/en/admin/login");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("hanh@gmail.com");

        WebElement pw = driver.findElement(By.name("password"));
        pw.sendKeys("12345678");

        WebElement rememberMe = driver.findElement(By.xpath("//label[@for=\"remember-me\"]"));
        rememberMe.click();
        Thread.sleep(3000);

        WebElement linkText = driver.findElement(By.linkText("forgot password?"));
        linkText.click();
        Thread.sleep(3000);
        driver.close();
    }
}
