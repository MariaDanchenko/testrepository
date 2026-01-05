package pageFactory;

import exercises.DropdownPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {

    private WebDriver driver;
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        dropdownPage = new DropdownPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSelectOption() {
        dropdownPage.selectOptionOne();
        String selectedOptionOne = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOptionOne, "Option 1");

        dropdownPage.selectOptionTwo();
        String selectedOptionTwo = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOptionTwo, "Option 2");
    }
}
