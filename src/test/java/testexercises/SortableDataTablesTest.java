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

public class SortableDataTablesTest {

    private WebDriver driver;

    @BeforeClass
    void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test
    void firstSeleniumTest() {
        WebElement linkSortableDataTables = driver.findElement(
                By.xpath("//a[@href='/tables']")); //ссылка на таблицы
        linkSortableDataTables.click(); //нажимаем на ссылку

        WebElement firstTitle = driver.findElement(
                By.xpath("//h4[text()='Example 1']")); //первый заголовок
        WebElement secondTitle = driver.findElement(
                By.xpath("//h4[text()='Example 2']")); //второй заголовок

        //Проверяю, что текст равен ожидаемому значению
        Assert.assertEquals(firstTitle.getText(), "Example 1");
        Assert.assertEquals(secondTitle.getText(), "Example 2");
    }
}
