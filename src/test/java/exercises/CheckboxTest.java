package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxTest {

    private WebDriver driver;
    private CheckboxPage checkboxPage;

    @BeforeClass
    void initAndOpenSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        checkboxPage = new CheckboxPage(driver);
        checkboxPage.open();
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test(testName = "Проверка что чекбокс выбран после нажатия на него")
    void verifyCheckboxSelectedAfterClickIt() {
        WebElement checkbox = checkboxPage.getCheckbox();

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected!");
    }
}
