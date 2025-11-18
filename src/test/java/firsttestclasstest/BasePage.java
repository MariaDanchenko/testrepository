package firsttestclasstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage { //объявление класса BasePage

    protected WebDriver driver; //объявление переменной driver, которая будет использоваться для взаимодействия с браузером

    public BasePage(WebDriver driver) {
        this.driver = driver;
    } //конструктор класса BasePage. Конструктор принимает объект WebDriver, который представляет веб драйвер браузера и мы присваиваем этот объект переменной driver, чтобы иметь возможность использовать его внутри класса

    // Метод для клика по элементу
    protected void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    } //метод clickElement, который используется для клика по элементу на веб-странице. Метод принимает аргумент By locator, который представляет собой локатор элемента. Мы используем driver.findElement(locator) для поиска элемента на странице и element.click(); для выполнения клика

    // Метод для ввода текста в поле
    protected void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    } //Метод enterText, который используется для ввода текстов в поле на веб-странице. Метод принимает аргументы By locator и String text. Мы используем driver.findElement(locator); для поиска поля на странице и element.sendKeys(text); для ввода текста в это поле

    protected boolean messageDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    } //метод messageDisplayed(By locator) используется для проверки того, отображается ли сообщение или элемент на веб-странице. Он принимает аргумент By locator, который представляет собой локатор элемента и возвращает булеан значение тру, если элемент отображается на странице и фолс в противном случае
}