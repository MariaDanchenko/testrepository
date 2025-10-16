package testcode.firsttest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class FirstSeleniumTest {
    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESSFUL_LOGIN = "Welcome to the Secure Area. When you are done click logout below.";

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeClass
    void initAndOpenSite() {
        WebDriverManager.chromedriver().setup(); // для автоматической настройки хром-драйвера
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/"); // двайвер get открывает сайт, который мы будем тестировать

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // изменила webDriverWait - это объект, который позволяет нам ожидать, пока определенный элементы, не станут видимыми или доступными для взаимодействия
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Welcome to the-internet']")
        )); // ожидаем, пока на странице появится заголовок с тектом 'Welcome to the-internet', чтобы убедиться, что сайт загружен корректно
    }

    @AfterClass(alwaysRun = true) // выполняется, когда все тесты завершатся
    void closeDriver() {
        driver.quit(); // driver.quit закрывается браузер, чтобы очистить ресурсы
    }

    @Test // основной тест
    void firstSeleniumTest() {
        var formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']")); // driver.findElement - находит элемент на странице By.xpath - это способ поиска элементов по их атрибутам или тексту и кликает по ссылке formAuthentication
        formAuthentication.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Login Page']")
        )); // ожидает, пока страница загрузится. в данном случае, пока не появится заголовок 'Login Page'

        var usernameInput = driver.findElement(By.xpath("//input[@id='username']")); // поле ввода логина
        var passwordInput = driver.findElement(By.xpath("//input[@id='password']")); // поле ввода пароля
        var loginButton = driver.findElement(By.xpath("//i[contains(text(), 'Login')]")); // кнопка входа

        usernameInput.sendKeys(LOGIN); // вводим логин
        passwordInput.sendKeys(PASSWORD); // вводим пароль
        loginButton.click(); // кликаем на кнопку для отправки формы

        var loginSuccessful = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h4[@class='subheader']")
        )); // ожидаем, пока появится элемент, который подтверждает успешный вход

        Assert.assertEquals(loginSuccessful.getText(), SUCCESSFUL_LOGIN, "Login is failed."); // с помощью assertEquals мы проверяем, что текст успешного входа соответствует тому, который мы ожидаем. если текст не совпадает, то тест провалится и мы увидим сообщение "Login is failed."
    }
}
