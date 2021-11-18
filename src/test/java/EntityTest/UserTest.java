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
        user = new User("duannie", "Annie", "Du", "yunqi.du@mail.utoronto.ca",
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
        assertEquals("123 Bay st", user.getAddress());
    }

    @Test
    public void testChangeUsername() {
        user.setUsername("grace");

        assertEquals(user.getUsername(), "grace");
    }

    @Test
    public void testRemoveFromEmptyInventory() {
        assertFalse(user.removeFromInventory("item1"));
    }


    @Test
    public void testRemoveFromEmptyshoppingcart() {
        assertFalse(user.removeFromshoppingcart("item1"));
    }

    @Test
    public void testAddtoRemoveFromInventory() {
        assertTrue(user.addToInventory("book5"));
        assertTrue(user.getInventory().contains("book5"));
        assertTrue(user.removeFromInventory("book5"));
        assertFalse(user.removeFromInventory("book50"));
        assertFalse(user.getInventory().contains("book5"));
    }

    @Test
    public void testAddtoRemoveFromshoppingcart() {
        assertTrue(user.addToshoppingcart("item1"));
        assertTrue(user.getShoppingcart().contains("item1"));
        assertTrue(user.removeFromshoppingcart("item1"));
        assertFalse(user.removeFromshoppingcart("item100"));
        assertFalse(user.removeFromshoppingcart("item1"));
        assertFalse(user.getShoppingcart().contains("item1"));
    }

}
