package demoDay6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test2 {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"#Multiple\"]")));
        button.click();

        WebElement iframe1 = driver.findElement(By.xpath("//div[@id=\"Multiple\"]/iframe"));
        driver.switchTo().frame(iframe1);
        WebElement iframe2 = driver.findElement(By.xpath("//div[@class=\"container\"]//iframe[@src=\"SingleFrame.html\"]"));
        driver.switchTo().frame(iframe2);

        List<WebElement> ls = driver.findElements(By.tagName("input"));
        ls.get(0).sendKeys("test");

        driver.close();
    }
}
