package main.gateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import main.entity.Book;

public class BookGateway extends Gateway {
    @Override
    public List<Book> getInfo() {
        return helperGetInfo("Database/Book.ser");
    }

    public void saveBooktoFile(ArrayList bookList){
        try
        {
            FileOutputStream fos = new FileOutputStream("src/main/java/Main.ConsoleUI.Database/Book.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookList);
            oos.close();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList readBookfromFile() {
        ArrayList bookList = new ArrayList<>();
        try {
            File file = new File("src/main/java/Main.ConsoleUI.Database/Book.ser");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            bookList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (EOFException e) {
            bookList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
