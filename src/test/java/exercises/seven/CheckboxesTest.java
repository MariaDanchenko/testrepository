package exercises.seven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckboxesTest {

    private WebDriver driver;
    private CheckboxesPage checkboxesPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        checkboxesPage = new CheckboxesPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCheckboxes() {

        List<ElementWrapper<WebElement>> wrappers = new ArrayList<>();

        List<WebElement> list = checkboxesPage.getCheckboxes();

        for (int i = 0; i < list.size(); i++) {

            WebElement checkbox;
            checkbox = list.get(i);

            ElementWrapper<WebElement> wrapper;
            wrapper = new ElementWrapper<>(checkbox);

            wrappers.add(wrapper);
        }

        for (int i = 0; i < wrappers.size(); i++) {

            ElementWrapper<WebElement> wrapper;
            wrapper = wrappers.get(i);

            boolean isChecked;
            isChecked = wrapper.isChecked();

            if (isChecked == false) {
                wrapper.toggle();
            }

            boolean finalState;
            finalState = wrapper.isChecked();

            Assert.assertTrue(finalState);
        }
    }
}
