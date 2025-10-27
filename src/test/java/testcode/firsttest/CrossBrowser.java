package testcode.firsttest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CrossBrowser extends BaseTest{
    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESSFUL_LOGIN = "Welcome to the Secure Area. When you are done click logout below.";

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
    }

    @AfterClass
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test // основной тест
    void crossBrowser() {
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

        var loginSuccessful = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[@class='subheader']")
        ));

        Assert.assertEquals(loginSuccessful.getText(), SUCCESSFUL_LOGIN, "Login is failed.");
    }
}
