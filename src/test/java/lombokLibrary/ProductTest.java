package lombokLibrary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {

        Product product = new Product();

        product.setName("Apple");
        product.setPrice(10);

        Assert.assertEquals(product.getName(), "Apple");
        Assert.assertEquals(product.getPrice(), 10);
    }
}
