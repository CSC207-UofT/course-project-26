package Gateway;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import Entity.User;
import Usecase.UserManager;
import service.UserService;

public class UserGateway extends Gateway implements UserService {
    public void saveUsertoFile(User[] userList){
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/Database/User.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Updates UserManager um to User.ser
     * @param um UserManager to be updated
     */
    public void updateUserInfo(UserManager um) {
        String fileName = "src/Database/User.ser";
        List<User> serList = new ArrayList<>();
        Map<String, User> umUserIdToUser = um.getUserIdToUser();
        for (Map.Entry<String, User> entry: umUserIdToUser.entrySet()){
            serList.add(entry.getValue());
        }
        updateInfo(serList, fileName);
    }

    @Override
    public List<User> getInfo() {
        return helperGetInfo("Database/User.ser");
    }

    @Override
    public ArrayList findAll() {
        ArrayList userList = new ArrayList<>();
        try {
            File file = new File("src/main/java/Database/User.ser");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            userList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (EOFException e) {
            userList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getStudentByUsername(String username) {
        return null;
    }

    @Override
    public void saveOrUpdate(User user) {
        User[] users = new User[]{user};
        saveUsertoFile(users);

    }

    @Override
    public void deleteByUsername(String username) {

    }
}
