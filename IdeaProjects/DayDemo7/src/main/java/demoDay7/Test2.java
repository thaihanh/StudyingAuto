package demoDay7;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class Test2 {
    @Test
    public void test() throws IOException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//                "D:\\WebDriver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
//        WebDriver driver = new PhantomJSDriver((desiredCapabilities));

        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demo.worksuite.biz/login");
        driver.manage().window().maximize();
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@example.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement loginBtn = driver.findElement(By.id("submit-login"));
        loginBtn.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[contains(text(),'Dashboard')])[1]")));
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D://demoPhantomJS.png"));
    }
}
