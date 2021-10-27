import Entity.User;
import Entity.Book;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;
    private Book book;

    @Before
    public void setUp(){
        user = new User("Annie", "duannie", "yunqi.du@mail.utoronto.ca",
                "123456","Bay");
        book = new Book(100, "CSC207","Grace", "Uoft", "OCt 9, 2020", 12, 400,
                "txt", "English", 1000, "L");
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
