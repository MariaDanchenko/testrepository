package testexercises;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTablesTest extends BaseTest {

    @Test
    void firstSeleniumTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLink();

        SortableDataTablesPage sortableDataTablesPage = new SortableDataTablesPage(driver);

        Assert.assertEquals(sortableDataTablesPage.getFirstTitle(), "Example 1");
        Assert.assertEquals(sortableDataTablesPage.getSecondTitle(), "Example 2");
    }
}
