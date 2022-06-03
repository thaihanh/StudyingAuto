import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 {
    @Test
    public void exercise1() {
        //Step 1
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.walmart.com/account/signup");

        driver.manage().window().maximize();
        String actualUrl = "https://www.walmart.com/account/signup";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Navigate to page successfully");

        //Step 2: Write the selectors of element by Id, Name, Class, XPath as below
        // First Name Text Box
        WebElement firstName = driver.findElement(By.id("first-name-su"));
        Assert.assertTrue(firstName.isDisplayed());
        //Last Name Text Box
        WebElement lastName = driver.findElement(By.id("last-name-su"));
        Assert.assertTrue(lastName.isDisplayed());
        //Email Address Text Box
        WebElement email = driver.findElement(By.id("email-su"));
        Assert.assertTrue(email.isDisplayed());
        //Create a Password Text Box
        WebElement password = driver.findElement(By.id("password-su"));
        Assert.assertTrue(password.isDisplayed());
        //Keep me signed in check box
        WebElement keepSignIn = driver.findElement(By.id("remember-me-su"));
        Assert.assertTrue(keepSignIn.isDisplayed());
        //Create Account Button
        WebElement createBtn = driver.findElement(By.xpath("//button[@type='submit' and text()='Create account'] "));
        Assert.assertTrue(createBtn.isDisplayed());
        //Sign in Button
        WebElement signInBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        Assert.assertTrue(signInBtn.isDisplayed());
        driver.close();
    }
}
