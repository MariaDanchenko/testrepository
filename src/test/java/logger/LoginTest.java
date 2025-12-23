package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

public class LoginTest {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
}
