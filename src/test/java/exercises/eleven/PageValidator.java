package exercises.eleven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageValidator {

    private final WebDriver driver;

    public PageValidator(WebDriver driver) {
        this.driver = driver;
    }

    public <T> TestResult<T> validateHeader(By locator, Class<T> type, String expectedText) {
        try {
            String actualText = driver.findElement(locator).getText();
            boolean isValid = actualText.equals(expectedText);

            if (type.equals(String.class)) {
                return new TestResult<>(type.cast(actualText), isValid, "Header text validation");
            }
            throw new IllegalArgumentException("Unsupported type");
        } catch (Exception e) {
            return new TestResult<>(null, false, "Validation failed");
        }
    }
}
