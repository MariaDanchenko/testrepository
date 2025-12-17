package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    @FindBy(className = "title")
    private WebElement productsTitle;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsTitleDisplayed() {
        return productsTitle.isDisplayed();
    }

    public String getTitleText() {
        return productsTitle.getText();
    }
}
