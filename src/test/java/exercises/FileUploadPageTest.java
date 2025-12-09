package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadPageTest {

    private WebDriver driver;
    private FileUploadPage fileUploadPage;

    @BeforeClass
    public void openSite() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        fileUploadPage = new FileUploadPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void testFileUpload() {
        fileUploadPage
                .selectFile("D:\\masha\\Курс автоматизации\\1\\DemoTestRepository\\src\\target\\тест.jpg");
        fileUploadPage.clickUpload();

        Assert.assertEquals(fileUploadPage.getMessage(), "File Uploaded!");
    }
}
