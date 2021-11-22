package UsecaseTest;

import main.usecase.UserManager;
import main.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserManagerTest {
    UserManager um;

    @Test
    public void test_id_management(){
        User user1 = new User("Grace", "password","Grace", "Liu", "grace@mail.utoronto.ca",
                "123 Bay st");
        User user2 = new User("Annie", "secondpassword","Annie", "778", "annie@mail.utoronto.ca",
                "778 Bay st");
        List<User> l1 = new ArrayList<User>();
        l1.add(user1);
        l1.add(user2);

        um = new UserManager(l1);
        assertEquals("Grace", user1.getUsername());
        assertEquals(user1, um.findAccountById(user1.getUsername()));
        assertEquals(user1.getUsername(), um.usernameById(user1.getUsername()));
    }
}
