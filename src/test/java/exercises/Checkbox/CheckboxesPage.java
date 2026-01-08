package exercises.Checkbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxesPage {

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    public CheckboxesPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public void toggleCheckbox(int index) {
        checkboxes.get(index).click();
    }
}
