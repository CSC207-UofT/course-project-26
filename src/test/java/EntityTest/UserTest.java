package EntityTest;

import Entity.User;
import Entity.Book;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        user = new User("Annie", "duannie", "yunqi.du@mail.utoronto.ca",
                "123 Bay st");
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
        assertEquals("123 Bay st", user.getaddress());
    }

    @Test
    public void testChangeUsername() {
        String userId = user.getId();
        user.setUsername("grace");

        assertEquals(user.getUsername(), "grace");
        assertEquals(user.getId(), userId);  // user ID should not change
    }

    @Test
    public void testRemoveFromEmptyInventory() {
        assertFalse(user.removeFromInventory("item1"));
    }

}
