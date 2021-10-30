package Gateway;

import java.io.*;
import java.util.ArrayList;

public class UserGateway {
    public void saveUsertoFile(ArrayList userList){
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/Database/UserData.ser");
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
            File file = new File("src/main/java/Database/UserData.ser");
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

}
