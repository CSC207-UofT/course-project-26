package EntityTest;

import main.entity.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        user = new User("duannie", "Annie", "Du",
                "yunqi.du@mail.utoronto.ca", "123 Bay st");
    }

    @Test
    public void testgetName(){
        assertEquals("Annie", user.getUsername());
    }

    @Test
    public void testgetemail(){
        assertEquals("yunqi.du@mail.utoronto.ca", user.getEmail());
    }

    @Test
    public void testgetaddress(){
        assertEquals("123 Bay st", user.getAddress());
    }

    @Test
    public void testChangeUsername() {
        String username = user.getUsername();
        user.setUsername("grace");

        assertEquals(user.getUsername(), "grace");
        assertEquals(user.getUsername(), username);  // user ID should not change
    }

}
