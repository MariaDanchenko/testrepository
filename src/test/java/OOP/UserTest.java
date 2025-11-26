package OOP;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Test
    void testGettersSetters() {
        User user = new User();

        user.setUsername("standard_user");
        user.setPassword("secret_sauce");

        Assert.assertEquals(user.getUsername(), "standard_user");
        Assert.assertEquals(user.getPassword(), "secret_sauce");
    }
}
