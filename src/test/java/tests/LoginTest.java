package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverManager;
import utils.ExcelUtils;

import java.util.List;

public class LoginTest {
    private LoginPage loginPage;
    private ExcelUtils excelUtils;

    @BeforeMethod
    public void setup() {
        // Declare driver as a local variable
        WebDriver driver = DriverManager.getDriver(); // Get the WebDriver instance
        DriverManager.navigateToDashboard(); // Navigate to the dashboard URL
        loginPage = new LoginPage(driver);
        excelUtils = new ExcelUtils(System.getProperty("user.dir") + "/Excel File/LoginData.xlsx", "Sheet1"); // Update path and sheet name
    }

    @Test
    public void testLogin() throws InterruptedException {
        List<String[]> loginData = excelUtils.getData();
        for (String[] data : loginData) {
            String username = data[0]; // Assuming username is in the first column
            String password = data[1]; // Assuming password is in the second column
            loginPage.login(username, password);
            // Add assertions to verify login success or failure fdfs
        }
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        excelUtils.close();
    }
}