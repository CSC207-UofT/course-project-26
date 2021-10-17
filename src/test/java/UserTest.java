import Users.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp(){
        user = new User("annie", "duannie", "yunqi.du@mail.utoronto.ca","123456","Bay");
    }

    @Test
    public void testgetName(){
        assertEquals("annie", user.getName());
    }

    @Test
    public void testgetemail(){
        assertEquals("annie", user.getEmail());
    }

    @Test
    public void testgetlocation(){
        assertEquals("annie", user.getLocation());
    }

}
