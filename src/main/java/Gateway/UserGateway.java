package Gateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entity.Admin;
import Entity.User;
import Usecase.AdminManager;
import Usecase.UserManager;

public class UserGateway extends Gateway {
    public void saveUsertoFile(ArrayList userList){
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

    public ArrayList readUserfromFile() {
        ArrayList userList = new ArrayList<>();
        try {
            File file = new File("src/main/java/Database/User.ser");
            file.createNewFile();
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
}
