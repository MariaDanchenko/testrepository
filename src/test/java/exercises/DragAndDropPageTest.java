package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropPageTest {

    private WebDriver driver;
    private DragAndDropPage dragAndDropPage;

    @BeforeClass
    public void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        dragAndDropPage = new DragAndDropPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void testDragAndDrop() {
        dragAndDropPage.dragAtoB();

        String afterA = dragAndDropPage.getBoxA().getText();
        String afterB = dragAndDropPage.getBoxB().getText();

        Assert.assertEquals(afterA, "B");
        Assert.assertEquals(afterB, "A");
    }
}
