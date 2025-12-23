package logger;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartTest {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogManager().getLogger(CartTest.class);
}
