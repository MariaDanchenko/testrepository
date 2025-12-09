package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptAlertsPageTest {

    private WebDriver driver;
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeClass
    public void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void testJSAlert() {
        javaScriptAlertsPage.clickForJSAlert();
        javaScriptAlertsPage.acceptAlert();

        Assert.assertEquals(javaScriptAlertsPage.getText(), "You successfully clicked an alert");
    }

    @Test
    public void testJSConfirmDismiss() {
        javaScriptAlertsPage.clickForJSConfirm();
        javaScriptAlertsPage.dismissAlert();

        Assert.assertEquals(javaScriptAlertsPage.getText(), "You clicked: Cancel");
    }

    @Test
    public void testJSConfirmAccept() {
        javaScriptAlertsPage.clickForJSConfirm();
        javaScriptAlertsPage.acceptAlert();

        Assert.assertEquals(javaScriptAlertsPage.getText(), "You clicked: Ok");
    }

    @Test
    public void testJSPromptText() {
        javaScriptAlertsPage.clickForJSPrompt();
        javaScriptAlertsPage.sendTextToAlert("Hello");

        Assert.assertEquals(javaScriptAlertsPage.getText(), "You entered: Hello");
    }

    @Test
    public void testJSPromptAccept() {
        javaScriptAlertsPage.clickForJSPrompt();
        javaScriptAlertsPage.acceptAlert();

        Assert.assertEquals(javaScriptAlertsPage.getText(), "You entered:");
    }

    @Test
    public void testJSPromptDismiss() {
        javaScriptAlertsPage.clickForJSPrompt();
        javaScriptAlertsPage.dismissAlert();

        Assert.assertEquals(javaScriptAlertsPage.getText(), "You entered: null");
    }
}
