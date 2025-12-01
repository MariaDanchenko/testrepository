package oop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest2 {

    @Test
    void testShortPassword() {
        User2 user = new User2();

        boolean shortPassword = user.setPassword("short");

        Assert.assertFalse(shortPassword);
        Assert.assertNull(user.getPassword());
    }
}
