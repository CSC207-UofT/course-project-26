import Entity.User;
import Entity.Book;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        user = new User("Annie", "duannie", "yunqi.du@mail.utoronto.ca",
                "123456","Bay");
    }

    @Test
    public void testgetName(){
        assertEquals("Annie", user.getName());
    }

    @Test
    public void testgetemail(){
        assertEquals("yunqi.du@mail.utoronto.ca", user.getEmail());
    }

    @Test
    public void testgetlocation(){
        assertEquals("Bay", user.getLocation());
    }

}
