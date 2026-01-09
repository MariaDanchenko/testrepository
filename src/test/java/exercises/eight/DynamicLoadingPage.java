package exercises.eight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogger()

    @FindBy(css = "a[href = '/dynamic_loading/1']")
    private WebElement link;

    @FindBy(xpath = "//div[@id='start']/button")
    private WebElement startButton;

    @FindBy(xpath = "//div[@id='finish']/h4")
    private WebElement loadingMessage;

    public DynamicLoadingPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLink() {
        link.click();
    }

    public void clickStartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(startButton));
        startButton.click();
    }

    public String getLoadingMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loadingMessage));

        return loadingMessage.getText();
    }
}
