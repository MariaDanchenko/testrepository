package oop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage extends Page {

    private final By addToCartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack"); //кнопка добавить в корзину
    private final By cartBadge = By.cssSelector("span[data-test='shopping-cart-badge']"); //цифра на корзине
    private final By navigationButton = By.cssSelector("#react-burger-menu-btn"); //кнопка навигации
    private final By logoutButton = By.cssSelector("#logout_sidebar_link");

    private final WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //добавляем в корзину
    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    //проверяем количество в корзине
    public String getCartBadge() {
        return driver.findElement(cartBadge).getText();
    }

    //открываем меню навигации
    public void openNavigation() {
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(navigationButton));
        driver.findElement(navigationButton).click();
    }

    //выходим из аккаунта
    public void logout() {
        openNavigation();
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}
