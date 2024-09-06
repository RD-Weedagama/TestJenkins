package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.name("reg_username");
    private By passwordField = By.id("reg_password");
    private By registerButton = By.id("registerButton");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void register(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }
}