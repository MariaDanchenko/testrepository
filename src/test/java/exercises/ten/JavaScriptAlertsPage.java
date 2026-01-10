package exercises.ten;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptAlertsPage {

    private WebDriver driver;
    private WebDriverWait wait;

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
    }

    public void clickJSAlert() {
        jsAlert.click();

    }

    public void clickJSConfirm() {
        jsConfirm.click();
    }

    public void clickJSPrompt() {
        jsPrompt.click();
    }

    public Alert waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public String getAlertText() {
        Alert alert = waitForAlert();
        String alertText = alert.getText();
        return alertText;
    }

    public void acceptAlert() {
        Alert alert = waitForAlert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = waitForAlert();
        alert.dismiss();
    }

    public void sendKeysToPrompt(String text) {
        Alert alert = waitForAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        String result = resultText.getText();
        return result;
    }
}
