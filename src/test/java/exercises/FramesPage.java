package exercises;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By nestedFramesLink = By.cssSelector("a[href='/nested_frames']");
    private final By iFrameLink = By.cssSelector("a[href='/iframe']");

    private final By iframe = By.cssSelector("#mce_0_ifr");
    private final By textArea = By.cssSelector("#tinymce");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openNestedFrames() {
        driver.findElement(nestedFramesLink).click();
    }

    public void openIFrame() {
        driver.findElement(iFrameLink).click();
    }

    public void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void setTextInIFrame(String text) {
        switchToFrame();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].innerHTML = arguments[1];",
                driver.findElement(textArea),
                text
        );

        switchToDefault();
    }

    public String getTextFromIFrame() {
        switchToFrame();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = (String) js.executeScript(
                "return arguments[0].innerHTML;",
                driver.findElement(textArea)
        );

        switchToDefault();
        return text;
    }
}
