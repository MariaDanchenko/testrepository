package lombokLibrary;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {

    @Test
    public void testNoArgsConstructor() {

        Customer customer = new Customer();
        Assert.assertNotNull(customer);
    }

    @Test
    public void testAllArgsConstructor() {

        int id = 123;
        String name = "Maria";

        Customer customer = new Customer(id, name);

        Assert.assertEquals(customer.getId(), id);
        Assert.assertEquals(customer.getName(), name);
    }
}
