package main.gateway;

import main.entity.Listing;
import main.usecase.ListingManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListingGateway extends Gateway{
    @Override
    public List<Listing> getInfo() {
        return helperGetInfo("Database/Book.ser");
    }

    public void saveListingtoFile(ArrayList listingList){
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/Main.ConsoleUI.Database/Listing.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listingList);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList readListingfromFile() {
        ArrayList listingList = new ArrayList<>();
        try {
            File file = new File("src/main/java/Main.ConsoleUI.Database/Listing.ser");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            listingList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (EOFException e) {
            listingList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listingList;
    }

    /**
     * Updates ListingManager lm to Listing.ser
     * @param lm ListingManager to be updated
     */
    public void updateUserInfo(ListingManager lm) {
        String fileName = "src/Main.ConsoleUI.Database/Listing.ser";
        List<Listing> serList = new ArrayList<>();
        Map<String, Listing> lmListingIdToUser = lm.getListingIdToListing();
        for (Map.Entry<String, Listing> entry: lmListingIdToUser.entrySet()){
            serList.add(entry.getValue());
        }
        updateInfo(serList, fileName);
    }

}