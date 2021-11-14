package Usecase;

import Entity.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BookManager is a use case for Book.
 *
 * IdToBook is a Map storing Id as key and Book as value
 */
public class BookManager {
    private final Map<String, Book> idToBook = new HashMap<>();

    /**
     * Create an BookManager with given books
     * @param allItems all current items in the system (if any)
     */
    public BookManager(List<Book> allItems) {
        for (Book book: allItems){
            idToBook.put(book.getId(), book);
        }
    }

    /**
     * Add Book to the BookManager
     * @param book Book to be added
     */
    public void addBook(Book book){
        if (idToBook.containsKey(book.getId()))
            return;
        idToBook.put(book.getId(), book);
    }

    /**
     * Create a new Book with given price, name author, publisher, pub_date, edition, pages, format, language, weight,
     * and size of the book, add it to the BookManager
     *
     * @return String The Name of the newly created Book.
     */
    public String createNewBook(double price, String name, String author, String publisher, String pub_date,
                                int edition, int pages, String format, String language, double weight, String size){
        Book newBook = new Book(price, name, author, publisher, pub_date, edition, pages, format, language, weight,
                size);
        addBook(newBook);
        return newBook.getName();
    }

    /**
     * Find a book with given Name
     * @param bookId The given Item id
     */
    public Book findBook(String bookId){
        return idToBook.get(bookId);
    }


    /**
     * Represent all books in the system.
     * @return A list of all bookId in the system
     */
    public List<String> getAllBooks() {
        return new ArrayList<>(idToBook.keySet());
    }

    /**
     * Get the map of book objects
     * @return Map of book id to book object
     */
    public Map<String, Book> getIdToBook() {
        return idToBook;
    }

    /**
     * Get the bookId based on book Object
     * @param book the Item object
     * @return the bookId in String
     */
    public String getItemIdByItem(Book book) {
        return book.getId();
    }

    /**
     * Set the book name
     * @param bookId itemId of the Item
     * @param newName the new name
     */
    public void setBookName(String bookId, String newName) {
        Book book = findBook(bookId);
        book.setName(newName);
    }

    /**
     * Converts bookIds into Book
     * @param bookIds List of bookIds to be converted
     * @return list of Book objects
     */
    public List<Book> giveListBook(List<String> bookIds) {
        List<Book> aa = new ArrayList<>();
        for (String bookId: bookIds) {
            aa.add(findBook(bookId));
        }
        return aa;
    }

}

