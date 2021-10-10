import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private boolean isSold;
    private double price;
    private String name;
    private String author;
    private String publisher;
    private String pub_date;
    private int edition;
    private int pages;
    private String format;
    private String language;
    private double weight;
    private String size;

    /**
     * Construct a Book with the following instance attributes:
     *
     * @param isSold    Whether the Book is sold or not. Default value is false TODO: I'm not sure why isSold parameter is red,
     * @param price     Selling price of the Book in Canadian Dollars
     * @param name      The name of the Book
     * @param author    The author of the Book
     * @param publisher The publisher of the Book
     * @param pub_date  The publish date of the Book in ... TODO: Choose what format to use for dates
     * @param edition   The edition of the Book
     * @param pages     The number of pages in the Book
     * @param format    The format of the Book. It can be either one of "Paperback", "Hardcover", "Looseleaf",
     *                  "Online code"
     * @param language  The language of the Book
     * @param weight    The weight of the Book in kilograms. Default value is N/A
     * @param size      The dimensions of the Book. Default value is N/A. TODO: Figure out how to store dimensions
     */

    public Book(double price,
                 String name,
                 String author,
                 String publisher,
                 String pub_date,
                 int edition,
                 int pages,
                 String format,
                 String language,
                 double weight,
                 String size
    ) {
        this.isSold = false;
        this.price = price;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pub_date = pub_date;
        this.edition = edition;
        this.pages = pages;
        this.format = format;
        this.language = language;
        this.weight = weight;
        this.size = size;

    }
    // TODO: Use overloading to create another constructor with fewer parameters

    public boolean isSold() {
        return this.isSold;
    }

    /**
     * Get the Book info in a list.
     *
     * @return a list of the information stored in the Book class.
     */
    public List<Object> getBookInfo() {
        return Arrays.asList(
            this.price,
            this.name,
            this.author,
            this.publisher,
            this.pub_date,
            this.edition,
            this.pages,
            this.format,
            this.language,
            this.weight,
            this.size);
    }

    public void setSold() {
        this.isSold = true;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
