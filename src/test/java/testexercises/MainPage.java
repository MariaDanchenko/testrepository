package testexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    private By linkSortableDataTables = By.xpath("//a[@href='/tables']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    void clickLink() {
        WebElement link = driver.findElement(linkSortableDataTables);
        link.click();
    }
}
