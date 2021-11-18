package main.gateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.entity.User;
import main.usecase.UserManager;
import main.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserGateway extends Gateway implements UserService {
    public void saveUsertoFile(User[] userList){
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/Main.ConsoleUI.Database/User.ser");
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
        String fileName = "src/Main.ConsoleUI.Database/User.ser";
        List<User> serList = new ArrayList<>();
        Map<String, User> umUserIdToUser = um.getUsernameToUser();
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
    public ArrayList<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            File file = new File("src/main/java/Main.ConsoleUI.Database/User.ser");
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
    public User getUserByUsername(String username) {
        ArrayList<User> users = findAll();
        for (User user: users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        System.out.println("Guest can not modify profile");
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
