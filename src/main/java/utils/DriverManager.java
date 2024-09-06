package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver driver;
    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public static WebDriver getDriver() {
        if (driver == null) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            String driverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void navigateToDashboard() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call getDriver() first.");
        }
        driver.get(BASE_URL);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}