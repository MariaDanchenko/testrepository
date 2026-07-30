package exercises.ten;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger logger = LogManager.getLogger(JavaScriptAlertsPage.class);

    @FindBy(css = "button[onclick = 'jsAlert()']")
    private WebElement jsAlert;

    @FindBy(css = "button[onclick = 'jsConfirm()']")
    private WebElement jsConfirm;

    @FindBy(css = "button[onclick = 'jsPrompt()']")
    private WebElement jsPrompt;

    @FindBy(id = "result")
    private WebElement resultText;

    public JavaScriptAlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("JavaScriptAlertsPage initialized");
    }

    public void clickJSAlert() {
        jsAlert.click();
        logger.info("Clicked on JS Alert button");

    }

    public void clickJSConfirm() {
        jsConfirm.click();
        logger.info("Clicked on JS Confirm button");
    }

    public void clickJSPrompt() {
        jsPrompt.click();
        logger.info("Clicked on JS Prompt button");
    }

    public Alert waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        logger.info("Alert is present");
        return driver.switchTo().alert();
    }

    public String getAlertText() {
        Alert alert = waitForAlert();
        String alertText = alert.getText();
        logger.info("Alert text: {}", alertText);
        return alertText;
    }

    public void acceptAlert() {
        Alert alert = waitForAlert();
        alert.accept();
        logger.info("Alert accepted");
    }

    public void dismissAlert() {
        Alert alert = waitForAlert();
        alert.dismiss();
        logger.info("Alert dismissed");
    }

    public void sendKeysToPrompt(String text) {
        Alert alert = waitForAlert();
        alert.sendKeys(text);
        logger.info("Text '{}' sent to prompt", text);
        alert.accept();
        logger.info("Prompt accepted");
    }

    public String getResultText() {
        String result = resultText.getText();
        logger.info("Result text: {}", result);
        return result;
    }
}
