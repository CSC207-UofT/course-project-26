package main.usecase;

import main.entity.Book;
import main.entity.User;

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
     * @param allBooks all current items in the system (if any)
     */
    public BookManager(List<Book> allBooks) {
        for (Book book: allBooks){
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
    public String createNewBook(double price, String name, String author, String publisher, int pub_year,
                                int edition, int pages, String format, String language, double weight, String size){
        Book newBook = new Book(price, name, author, publisher,
//                pub_year,
                edition, pages, format, language, weight, size);
        addBook(newBook);
        return newBook.getName();
    }

    /**
     * Create a new Book with given price, name author, publisher, pub_date, edition, pages, format and language
     * of the book, add it to the BookManager
     *
     * @return String The Name of the newly created Book.
     */
    public String createNewBook(double price, String name, String author, String publisher,
//                               int pub_year,
                                int edition, int pages, String format, String language){
        Book newBook = new Book(price, name, author, publisher,
//                pub_year,
                edition, pages, format, language);
        addBook(newBook);
        return newBook.getName();
    }

    /**
     * Create a new Book with given price, name author, publisher and pub_date of the book, add it to the BookManager
     *
     * @return String The Name of the newly created Book.
     */
    public String createNewBook(double price, String name, String author, String publisher
//                               , int pub_year
    ){
        Book newBook = new Book(price, name, author, publisher
//                , pub_year
        );
        addBook(newBook);
        return newBook.getName();
    }

    /**
     * Find a book with given Name
     * @param bookId The given book id
     */
    public Book findBookById(String bookId) {
        return this.idToBook.get(bookId);
    }



    /**
     * Represent all books in the system.
     * @return A list of all bookId in the system
     */
    public List<String> getAllBooks() {
        return new ArrayList<>(idToBook.keySet());
    }

    public List<String> getBookIdList() {
        return new ArrayList<>(getIdToBook().keySet());
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
     * @param book the book object
     * @return the bookId in String
     */
    public String getBookIdByBook(Book book) {
        return book.getId();
    }


    public String getBookNameById(String bookId) {return findBookById(bookId).getName();}
    /**
     *
     * Set the book name
     * @param bookId bookId of the book
     * @param newName the new name
     */
    public void setBookName(String bookId, String newName) {
        Book book = findBookById(bookId);
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
            aa.add(findBookById(bookId));
        }
        return aa;
    }


}

