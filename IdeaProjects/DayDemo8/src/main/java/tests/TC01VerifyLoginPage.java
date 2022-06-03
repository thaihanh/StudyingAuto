package tests;

import core.BasePage;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC01VerifyLoginPage extends BaseTest {

    @Test
    public void tc01VerifyLogin(){
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        loginPage.navigateToLogin("http://139.162.47.20/magento222/admin");
        getDriver().manage().window().maximize();
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.login("admin","admin123");
        Assert.assertTrue(dashboardPage.verifyDashboard());
    }
}
