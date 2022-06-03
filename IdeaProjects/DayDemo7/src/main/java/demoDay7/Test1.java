package demoDay7;

import io.netty.handler.codec.socksx.v5.DefaultSocks5InitialRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Test1 {
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browserName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browserName);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
        driverThreadLocal.set(driver);
    }
    public WebDriver getDriver(){
        return driverThreadLocal.get();
    }
    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().get("https://demo.worksuite.biz/login");
        getDriver().manage().window().maximize();
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("admin@example.com");
        WebElement password = getDriver().findElement(By.id("password"));
        password.sendKeys("123456");
        WebElement loginBtn = getDriver().findElement(By.id("submit-login"));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[contains(text(),'Dashboard')])[1]")));
    }
    @AfterTest
    public void afterTest(){
        driverThreadLocal.remove();
    }
}
