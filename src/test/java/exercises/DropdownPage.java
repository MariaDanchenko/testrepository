package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    @FindBy(css = "option[value='1']")
    private WebElement optionOne;

    @FindBy(css = "option[value='2']")
    private WebElement optionTwo;

    public DropdownPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void selectOptionOne() {
        optionOne.click();
    }

    public void selectOptionTwo() {
        optionTwo.click();
    }

    public String getSelectedOptionText() {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }
}
