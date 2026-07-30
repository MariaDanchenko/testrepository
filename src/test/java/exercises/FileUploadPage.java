package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By selectFile = By.cssSelector("#file-upload");
    private final By uploadButton = By.cssSelector("#file-submit");
    private final By message = By.tagName("h3");

    public FileUploadPage(WebDriver driver) {

        this.driver = driver;
    }

    public void selectFile(String fullPath) {

        driver.findElement(selectFile).sendKeys(fullPath);
    }

    public void clickUpload() {

        driver.findElement(uploadButton).click();
    }

    public String getMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        return messageElement.getText();
    }
}
