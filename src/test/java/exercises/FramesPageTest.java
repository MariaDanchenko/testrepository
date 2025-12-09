package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesPageTest {

    private WebDriver driver;
    private FramesPage framesPage;

    @BeforeClass
    public void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();

        framesPage = new FramesPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    @BeforeMethod
    public void goToFramesPage() {
        driver.get("https://the-internet.herokuapp.com/frames");
    }

    @Test
    public void testNestedFrames() {

        framesPage.openNestedFrames();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        Assert.assertEquals(driver.findElement(By.tagName("body")).getText(), "LEFT");

        driver.switchTo().defaultContent();
    }

    @Test
    public void testIFrame() {

        framesPage.openIFrame();
        framesPage.setTextInIFrame("Hello World!");

        Assert.assertEquals(framesPage.getTextFromIFrame(), "Hello World!");
    }
}