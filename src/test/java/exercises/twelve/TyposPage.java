package exercises.twelve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TyposPage {

    private WebDriver driver;

    @FindBy(tagName = "h3")
    private WebElement header;

    @FindBy(xpath = "//p[2]")
    private WebElement typoText;

    public TyposPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getTypoText() {
        return typoText.getText();
    }

    public boolean containsTypo() {
        String correctText = "Sometimes you'll see a typo, other times you won't.";
        return !getTypoText().equals(correctText);
    }
}
