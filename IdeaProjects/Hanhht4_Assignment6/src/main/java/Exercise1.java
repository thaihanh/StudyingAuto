import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise1 {
    @Test
    public void test() throws InterruptedException, AWTException, IOException {
        //----------------------------------------------------Java Script Alert Box-------------------------------------------------------------------
        //1. Open Chrome browser
        //2. Maximize the browser window
        //3. Navigate to https://www.seleniumeasy.com/test/javascript-alert-box-demo.html webpage
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        //4. In Java Script Alert Box, click “Click Me” and Capture the alert’s text
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickMeBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='myAlertFunction()']")));
        clickMeBtn.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        // Capture the screen when alert displayed
        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        String screenshotPath = System.getProperty("user.dir")+"//Screenshots//Exercise1.png";
        ImageIO.write(bufferedImage,"png", new File(screenshotPath));

        Alert alert = driver.switchTo().alert();
        System.out.println("Text: " + alert.getText());
        alert.accept();

        //----------------------------------------------------Java Script Alert Box-------------------------------------------------------------------
        //1. In Java Script Confirm Box, click “Click Me”.
        WebElement clickMeBtn2 = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        clickMeBtn2.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        //2. Get the alert’s text and click OK button
        Alert alert2 = driver.switchTo().alert();
        System.out.println("Text: " + alert2.getText());
        alert2.accept();
        //3. Check Expected test as “You pressed OK”
        WebElement confirmText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-demo")));
        Assert.assertTrue(confirmText.isDisplayed(), "Check Expected test message is not displayed");

        //----------------------------------------------------Java Script Prompt Box-------------------------------------------------------------------
        //4. In Java Script Alert Box, click “Click for Prompt Box”
        WebElement clickMeBtn3 = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        clickMeBtn3.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        //5. Input your name.
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("demo");
        //6. Click OK button and verify message “You have entered 'Enter name'!”
        alert3.accept();
        WebElement message = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt-demo")));
        String expectMsg = "You have entered 'demo' !";
        String actualMsg = message.getText();
        Assert.assertEquals(expectMsg,actualMsg);

        //7. Close browser
        driver.close();
    }
}
