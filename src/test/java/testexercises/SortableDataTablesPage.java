package testexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortableDataTablesPage {

    private WebDriver driver;

    private By firstTitle = By.xpath("//h4[text()='Example 1']"); //первый заголовок
    private By secondTitle = By.xpath("//h4[text()='Example 2']"); //второй заголовок

    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstTitle() {
        WebElement title = driver.findElement(firstTitle);
        return title.getText();
    }

    public String getSecondTitle() {
        WebElement title = driver.findElement(secondTitle);
        return title.getText();
    }
}
