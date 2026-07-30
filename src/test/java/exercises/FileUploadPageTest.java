package exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

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
    public void testFileUpload() throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("test.jpg");

        File testFile = new File(resource.toURI());
        String absolutePath = testFile.getAbsolutePath();

        fileUploadPage.selectFile(absolutePath);
        fileUploadPage.clickUpload();

        Assert.assertEquals(fileUploadPage.getMessage(), "File Uploaded!");
    }
}
