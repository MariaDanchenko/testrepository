package exercises;

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
        List<Checkbox> checkboxList = new ArrayList<>();

        List<WebElement> elements = checkboxesPage.getCheckboxes();

        for (int i = 0; i < elements.size(); i++) {
            boolean isChecked = elements.get(i).isSelected();
            checkboxList.add(new Checkbox("checkbox-" + i, isChecked));
        }

        checkboxesPage.toggleCheckbox(0);

        checkboxList.get(0).setChecked(elements.get(0).isSelected());

        Assert.assertEquals(elements.get(0).isSelected(), checkboxList.get(0).isChecked());
    }
}
