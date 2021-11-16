package EntityTest;

import main.entity.Account;
import main.entity.Admin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminTest {
    @Before
    public void setUp(){
        Admin admin = new Admin("Grace", "123");
    }

    @Test
    public void testgetName(){
        Account admin = new Admin("Grace", "123");
        assertEquals("Grace", admin.getUsername());
    }

    @Test
    public void testgetPassword(){
        Account admin = new Admin("Grace", "123");
        assertEquals("123", admin.getPassword());
    }


    @Test
    public void testChangeUsername() {
        Account admin = new Admin("Grace", "123");
        admin.setUsername("annie");
        assertEquals(admin.getUsername(), "annie");

    }

    @Test
    public void testChangePassword() {
        Account admin = new Admin("Grace", "123");
        admin.setUsername("annie");
        assertEquals(admin.getPassword(), "123");
        admin.setPassword("456");
        assertEquals(admin.getPassword(), "456");

    }

}
