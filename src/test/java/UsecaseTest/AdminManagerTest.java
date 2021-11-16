package UsecaseTest;

import main.entity.Admin;
import main.usecase.AdminManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminManagerTest {
    AdminManager am;

    @Test
    public void test_id_management() {
        Admin admin1 = new Admin("Grace", "123");
        Admin admin2 = new Admin("Annie", "778");
        List<Admin> l1 = new ArrayList<Admin>();
        l1.add(admin1);
        l1.add(admin2);

        am = new AdminManager(l1);
        assertEquals("Grace", admin1.getUsername());
        assertEquals(admin1, am.findAccountById(admin1.getId()));
        assertEquals(admin1.getUsername(), am.usernameById(admin1.getId()));
    }
}
