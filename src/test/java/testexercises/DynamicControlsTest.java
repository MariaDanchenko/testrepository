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
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test
    void firstSeleniumTest() {
        WebElement inputField = driver.findElement(
                By.xpath("//input[@type='text']")); //поле ввода
        WebElement buttonEnableDisable = driver.findElement(
                By.xpath("//button[@onclick = 'swapInput()']")); //кнопка Enable
        buttonEnableDisable.click(); //нажимаем на кнопку Enable

        WebElement enableMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@id='message' and text()=\"It's enabled!\"]"))); // сообщение “It’s enabled!”

        Assert.assertTrue(inputField.isEnabled()); //проверяю, что поле активно
        Assert.assertTrue(enableMessage.isDisplayed()); //проверяю, что появилось сообщение

        WebElement buttonRemove = driver.findElement(
                By.xpath("//button[@onclick = 'swapCheckbox()']")); //кнопка Remove
        buttonRemove.click(); //нажимаем на кнопку Remove
        WebElement removeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[@id='message' and text()=\"It's gone!\"]"))); //сообщение "It's gone!"

        wait.until(ExpectedConditions.textToBePresentInElement(buttonRemove, "Add")); //Ждем, пока в элементе появится текст Add

        Assert.assertEquals(buttonRemove.getText(), "Add"); //Проверяю, что текст внутри кнопки заменяется на Add
        Assert.assertTrue(removeMessage.isDisplayed()); //Проверяю, что появилось сообщение
    }
}
