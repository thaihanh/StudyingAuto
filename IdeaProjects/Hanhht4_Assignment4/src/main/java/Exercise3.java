import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise3 {
    @Test
    public void exercise3() throws InterruptedException {
        //Step 1: Navigate to the URL:  https://www.seleniumeasy.com/test/basic-radiobutton-demo.html  in Chrome browser
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        driver.manage().window().maximize();
        String actualUrl = "https://demo.seleniumeasy.com/basic-radiobutton-demo.html";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Step 1: Passed");

        //Step 2: Looking for “Group Radio Buttons Demo”
        WebElement grRadioBtnsDemo = driver.findElement(By.xpath("//div[text()='Group Radio Buttons Demo']"));
        Assert.assertTrue(grRadioBtnsDemo.isDisplayed());
        System.out.println("Step 2: Passed");
        //Step 3: Select “Male”
        List<WebElement> lsGender = driver.findElements(By.name("gender"));
        for (WebElement gender: lsGender){
            if(!gender.isSelected()){
                if(gender.getAttribute("value").equals("Male")){
                    gender.click();
                }
            }
        }
        Thread.sleep(4000);
        System.out.println("Step 3: Passed");

        //Step 4: Select Age group: 5 to 15
        List<WebElement> lsAgeGr = driver.findElements(By.name("ageGroup"));
        for (WebElement ageGr: lsAgeGr){
            if(!ageGr.isSelected()){
                if(ageGr.getAttribute("value").equals("5 - 15")){
                    ageGr.click();
                }
            }
        }
        Thread.sleep(4000);
        System.out.println("Step 4: Passed");

        //Step 5: Click “Get Values” button
        WebElement getValuesBtn = driver.findElement(By.xpath("//button[text()='Get values']"));
        getValuesBtn.click();
        Thread.sleep(4000);
        System.out.println("Step 5: Passed");

        //Step 6: Verify message display
        WebElement message = driver.findElement(By.xpath("(//div[@class='panel panel-default'])[3]//p[@class='groupradiobutton']"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println("Step 6: Passed");

        driver.close();
    }
}
