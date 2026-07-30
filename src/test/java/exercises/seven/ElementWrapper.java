package exercises.seven;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
@AllArgsConstructor
public class ElementWrapper<T> {

    private T element;

    public T get() {
        return element;
    }

    public boolean isChecked() {
        if (element instanceof WebElement) {
            return ((WebElement) element).isSelected();
        }
        throw new UnsupportedOperationException("Element is not a checkbox");
    }

    public void toggle() {
        if (element instanceof WebElement) {
            ((WebElement) element).click();
        } else {
            throw new UnsupportedOperationException("Element is not clickable");
        }
    }
}
