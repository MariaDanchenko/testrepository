package exercises.ten;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest {

    private WebDriver driver;
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testJSAlerts() {
        javaScriptAlertsPage.clickJSAlert();
        String alertText = javaScriptAlertsPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        javaScriptAlertsPage.acceptAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You successfully clicked an alert");
    }

    @Test
    public void testJSConfirmAccept() {
        javaScriptAlertsPage.clickJSConfirm();
        String alertText = javaScriptAlertsPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS Confirm");
        javaScriptAlertsPage.acceptAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You clicked: Ok");
    }

    @Test
    public void testJSConfirmDismiss() {
        javaScriptAlertsPage.clickJSConfirm();
        javaScriptAlertsPage.dismissAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You clicked: Cancel");
    }

    @Test
    public void testJSPromptSendKeys() {
        javaScriptAlertsPage.clickJSPrompt();
        String alertText = javaScriptAlertsPage.getAlertText();
        Assert.assertEquals(alertText, "I am a JS prompt");
        javaScriptAlertsPage.sendKeysToPrompt("masha");
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You entered: masha");
    }

    @Test
    public void testJSPromptDismiss() {
        javaScriptAlertsPage.clickJSPrompt();
        javaScriptAlertsPage.dismissAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You entered: null");
    }
}
