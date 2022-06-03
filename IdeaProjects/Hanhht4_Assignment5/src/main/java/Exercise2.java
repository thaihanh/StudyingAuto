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

public class Exercise2 {
    @Test
    public void test() throws InterruptedException, IOException, AWTException {
        //1. Open Chrome browser
        //2. Maximize the browser window
        //3. Navigate to http://demo.guru99.com/test/simple_context_menu.html webpage
        System.setProperty("webdriver.chrome.driver","D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();

        //4. Verify “Double-Click Me To See Alert” button displayed
        WebElement button = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        Assert.assertTrue(button.isDisplayed(),"Double-Click Me To See Alert button is not displayed");
        //5. Double-Click the button
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();

        //6. Capture the screen when alert displayed
        Robot robot = new Robot();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(dimension);
        BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
        String screenshotPath = System.getProperty("user.dir")+"//Screenshots//Exercise2.png";
        ImageIO.write(bufferedImage,"png", new File(screenshotPath));
    }
}
