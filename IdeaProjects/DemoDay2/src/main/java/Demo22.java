import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Demo22 {
    @Test
    public void Test() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","D:\\WebDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://fleetcart.envaysoft.com/en/register");

        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("first_name"));
        firstName.sendKeys("Hoang");

        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.sendKeys("Hanh");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("Hanh@gmail.com");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("Hanh");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");

        WebElement confirmPassword = driver.findElement(By.name("password_confirmation"));
        confirmPassword.sendKeys("123456");

        WebElement captcha = driver.findElement(By.name("captcha"));
        captcha.sendKeys("123456");

        Thread.sleep(2000);
        //driver.close();
    }
}
