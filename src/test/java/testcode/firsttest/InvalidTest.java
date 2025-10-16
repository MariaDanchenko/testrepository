package testcode.firsttest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class InvalidTest {
    private static final String LOGIN = "tomsmith3";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESSFUL_LOGIN = "Welcome to the Secure Area. When you are done click logout below.";

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeClass
    void initAndOpenSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Welcome to the-internet']")
        ));
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test // основной тест
    void invalidTest() {
        var formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
        formAuthentication.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Login Page']")
        ));

        var usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
        var passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        var loginButton = driver.findElement(By.xpath("//i[contains(text(), 'Login')]"));

        usernameInput.sendKeys(LOGIN);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();

        var loginInvalid = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("flash")
        ));

        String errorText = loginInvalid.getText();
        Assert.assertTrue(
                errorText.contains("Your username is invalid!") ||
                        errorText.contains("Your password is invalid!"),
                "Error message is not displayed or text is incorrect."
        );

        takeScreenshot("invalidLogin_" + ".png");
    }

    void takeScreenshot(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(srcFile.toPath(), Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
