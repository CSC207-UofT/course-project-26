import Entity.User;
import Entity.Book;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        user = new User("Annie", "duannie", "123 Bay st",
                "yunqi.du@mail.utoronto.ca");
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

}
