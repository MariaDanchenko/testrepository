package testexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesTest {

    private WebDriver driver;

    @BeforeClass
    void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test
    void firstSeleniumTest() {
        WebElement firstCheckbox = driver.findElement(By.cssSelector("input[type=checkbox]:nth-child(1)"));
        WebElement secondCheckbox = driver.findElement(By.cssSelector("input[type=checkbox]:nth-child(3)"));

        Assert.assertTrue(secondCheckbox.isSelected());
        Assert.assertFalse(firstCheckbox.isSelected());
    }
}
