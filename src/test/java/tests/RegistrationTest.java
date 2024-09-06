package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.DriverManager;
import utils.ExcelUtils;

import java.util.List;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private ExcelUtils excelUtils;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://example.com/register"); // Replace with your registration URL
        registrationPage = new RegistrationPage(driver);
        excelUtils = new ExcelUtils("path/to/excel/file.xlsx", "RegistrationData"); // Update path and sheet name
    }

    @Test
    public void testRegistration() {
        List<String[]> registrationData = excelUtils.getData();
        for (String[] data : registrationData) {
            String username = data[0]; // Assuming username is in the first column
            String password = data[1]; // Assuming password is in the second column
            registrationPage.register(username, password);
            // Add assertions to verify registration success or failure
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        excelUtils.close();
    }
}