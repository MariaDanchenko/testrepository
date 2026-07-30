    package exercises.ten;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Test;

    public class JavaScriptAlertsTest {

        private WebDriver driver;
        private JavaScriptAlertsPage javaScriptAlertsPage;
        private static final Logger logger = LogManager.getLogger(JavaScriptAlertsTest.class);

        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().clearDriverCache().setup();

            driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            logger.info("Browser started");

            javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed");
            }
        }

        @Test
        public void testJSAlerts() {
            javaScriptAlertsPage.clickJSAlert();
            String alertText = javaScriptAlertsPage.getAlertText();
            Assert.assertEquals(alertText, "I am a JS Alert");
            javaScriptAlertsPage.acceptAlert();
            Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You successfully clicked an alert");
            logger.info("JS Alert test completed successfully");
        }

        @Test
        public void testJSConfirmAccept() {
            javaScriptAlertsPage.clickJSConfirm();
            String alertText = javaScriptAlertsPage.getAlertText();
            Assert.assertEquals(alertText, "I am a JS Confirm");
            javaScriptAlertsPage.acceptAlert();
            Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You clicked: Ok");
            logger.info("JS Confirm (accept) test completed successfully");
        }

        @Test
        public void testJSConfirmDismiss() {
            javaScriptAlertsPage.clickJSConfirm();
            javaScriptAlertsPage.dismissAlert();
            Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You clicked: Cancel");
            logger.info("JS Confirm (dismiss) test completed successfully");
        }

        @Test
        public void testJSPromptSendKeys() {
            javaScriptAlertsPage.clickJSPrompt();
            String alertText = javaScriptAlertsPage.getAlertText();
            Assert.assertEquals(alertText, "I am a JS prompt");
            javaScriptAlertsPage.sendKeysToPrompt("masha");
            Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You entered: masha");
            logger.info("JS Prompt (send keys) test completed successfully");
        }

        @Test
        public void testJSPromptDismiss() {
            javaScriptAlertsPage.clickJSPrompt();
            javaScriptAlertsPage.dismissAlert();
            Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You entered: null");
            logger.info("JS Prompt (dismiss) test completed successfully");
        }
    }
