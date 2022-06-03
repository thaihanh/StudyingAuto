import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Exercise3 {
    @Test
    public void test() throws InterruptedException, AWTException, IOException {
        //1. Open Chrome browser
        //2. Maximize the browser window
        //3. Navigate to http://demo.guru99.com/test/simple_context_menu.html webpage
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        //4. Verify “Right click me” displayed
        Actions actions = new Actions(driver);
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Assert.assertTrue(rightClick.isDisplayed(),"“Right click me” button is not displayed");
        //5. Right Click “Right click me”
        //6. Click “Edit” item
        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']/.."));
        actions.contextClick(rightClick).moveToElement(edit).click().build().perform();
        Thread.sleep(4000);
        //7. Capture the screen when alert displayed
        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        String screenshotPath = System.getProperty("user.dir")+"//Screenshots//Exercise3.png";
        ImageIO.write(bufferedImage,"png", new File(screenshotPath));
    }
}
