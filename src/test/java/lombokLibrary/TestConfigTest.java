package lombokLibrary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestConfigTest {

    @Test
    public void testURL() {
        TestConfig config = new TestConfig();

        Assert.assertEquals(config.getBaseUrl(), "https://www.saucedemo.com/");
    }
}
