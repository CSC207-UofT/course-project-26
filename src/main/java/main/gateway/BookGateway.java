package main.gateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.entity.Book;
import main.entity.Listing;
import main.usecase.BookManager;

public class BookGateway extends Gateway {
    @Override
    public List<Book> getInfo() {
        return helperGetInfo("Database/Book.ser");
    }

    public void saveBooktoFile(BookManager books){
        String fileName = "src/database/Book.ser";
        List<Book> serList = new ArrayList<>();
        Map<String, Book> BookIdToUser = books.getIdToBook();
        for (Map.Entry<String, Book> entry: BookIdToUser.entrySet()){
            serList.add(entry.getValue());
        }
        updateInfo(serList, fileName);
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
