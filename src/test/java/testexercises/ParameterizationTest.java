package testexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement inputField;

    @BeforeClass
    void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        inputField = driver.findElement(
                By.xpath("//input[@type='text']")); //поле ввода
        WebElement buttonEnableDisable = driver.findElement(
                By.xpath("//button[@onclick = 'swapInput()']")); //кнопка Enable
        buttonEnableDisable.click(); //нажимаем на кнопку Enable

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@id='message' and text()=\"It's enabled!\"]"))); // сообщение “It’s enabled!”
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test(dataProvider = "inputData")
    void firstSeleniumTest(String inputText) {

        inputField.clear(); //очищаем поле
        inputField.sendKeys(inputText); //вставляем текст

        Assert.assertEquals(inputField.getAttribute("value"), inputText); //проверяем, что текст совпадает
    }

    @DataProvider(name = "inputData")
    public Object[][] inputData() {
        return new Object[][]{
                {"Привет, мир!"},
                {"Как дела?"},
                {"Что делаешь?"}
        };
    }
}
