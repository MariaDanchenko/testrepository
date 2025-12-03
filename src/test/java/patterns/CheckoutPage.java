package patterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private final By firstNameField = By.cssSelector("#first-name");
    private final By lastNameField = By.cssSelector("#last-name");
    private final By zipField = By.cssSelector("#postal-code");
    private final By continueButton = By.cssSelector("#continue");
    private final By titlecheckout = By.cssSelector(".title");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterZip(String zip) {
        driver.findElement(zipField).sendKeys(zip);
    }

    public void fillCheckoutForm(String firstName, String lastName, String zip) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZip(zip);
    }

    public void continueCheckout() {
        driver.findElement(continueButton).click();
    }

    public boolean isCheckoutSummaryDisplayed() {
        return driver.findElement(titlecheckout).getText().equals("Checkout: Overview");
    }
}
