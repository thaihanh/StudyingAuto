package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TC01VerifyLoginPage extends BaseTest {

    @Test(dataProvider = "testdata")
    public void tc01VerifyLogin(String url, String username, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        loginPage.navigateToLogin(url);
        getDriver().manage().window().maximize();
        Assert.assertTrue(loginPage.verifyLoginPage());
        loginPage.login(username, password);
        Assert.assertTrue(dashboardPage.verifyDashboard());
    }
    @DataProvider(name = "testdata")
    public Object[][] getTestData(){
        return ExcelUtils.getTableArray("D:\\dataTest.xlsx", "TC01", 0, 3);
    }
}
