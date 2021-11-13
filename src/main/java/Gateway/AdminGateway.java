package Gateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Entity.Admin;
import Usecase.AdminManager;

public class AdminGateway extends Gateway {

    public AdminGateway() {

    }

    /**
     * Get information from admin.ser
     * @return List of admins from .ser
     */
    @Override
    public List<Admin> getInfo() {
        return helperGetInfo("Database/Admin.ser");
    }

    public void saveadmintoFile(ArrayList adminList){
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/Database/adminData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adminList);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList readadminfromFile() {
        ArrayList adminList = new ArrayList<>();
        try {
            File file = new File("src/main/java/Database/adminData.ser");
            file.createNewFile();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            adminList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (EOFException e) {
            adminList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return adminList;
    }

    /**
     * Updates AdminManager adm to admin.ser
     * @param adm AdminManager to be updated
     */
    public void updateAdminInfo(AdminManager adm) {
        String fileName = "src/database/Admin.ser";
        List<Admin> serList = new ArrayList<>();
        Map<String, Admin> admAdminIdToUser = adm.getAdminIdToUser();
        for (Map.Entry<String, Admin> entry: admAdminIdToUser.entrySet()){
            serList.add(entry.getValue());
        }
        updateInfo(serList, fileName);
    }



}
