package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Book {

    /**
     * Construct a Entity.Book with the following instance attributes:
     *
     *  id: The unique identifier of the Entity.Book
     *  name: The name of the Entity.Book
     *  author: The author of the Entity.Book
     *  publisher: The publisher of the Entity.Book
     *  pub_date: The publish date of the Entity.Book in ...  with the format yyyy-MM-dd in string
     *  edition: The edition of the Entity.Book
     *  pages: The number of pages in the Entity.Book
     *  format: The format of the Entity.Book. It can be either one of "Paperback", "Hardcover", "Looseleaf",
     *          "Online code"
     *  language: The language of the Entity.Book
     *  weight: The weight of the Entity.Book in kilograms. Default value is N/A
     *  size: The dimensions of the Entity.Book. Default value is N/A. TODO: Decide how to store dimensions
     */

    private String id;
    private double price;
    private String name;
    private String author;
    private String publisher;
    private DateTimeFormatter pub_date;
    private int edition;
    private int pages;
    private String format;
    private String language;
    private double weight;
    private String size;

    /**
     * Constructor for "Book."
     */
    public Book(double price, String name, String author, String publisher, String pub_date, int edition,
                int pages, String format, String language, double weight, String size) {
        UUID inputId = UUID.randomUUID();
        this.id = String.valueOf(inputId);
        this.price = price;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pub_date = DateTimeFormatter.ofPattern(pub_date);
        this.edition = edition;
        this.pages = pages;
        this.format = format;
        this.language = language;
        this.weight = weight;
        this.size = size;
    }
    // TODO: Use overloading to create another constructor with fewer parameters (in case some of the info isn't known about the book when it's initialized)


    /**
     * Get the Entity.Book info in a list.
     *
     * @return a list of the information stored in the Entity.Book class.
     */
    public List<Object> getBookInfo() {
        return Arrays.asList(
                this.id,
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
    //getter methods start here...
    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public String getAuthor(){return this.author;}
    public String getPublisher(){return this.publisher;}
    public String getPub_date(){return this.pub_date.toString();}
    public String getFormat(){return this.format;}
    public String getLanguage(){return this.language;}
    public String getSize(){return this.size;}
    public int getEdition(){return this.edition;}
    public int getPages(){return this.pages;}
    public double getPrice(){return this.price;}
    public double getWeight(){return this.weight;}

    // setter methods start here...
    public void setId(String id) {this.id = id;}
    public void setPrice(double price) {this.price = price;}
    public void setName(String name){this.name = name;}
    public void setAuthor(String author){this.author = author;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public void setPub_date(String pub_date){this.pub_date = DateTimeFormatter.ofPattern(pub_date);}
    public void setEdition(int edition){this.edition = edition;}
    public void setPages(int pages){this.pages = pages;}
    public void setFormat(String format){this.format = format;}
    public void setLanguage(String language){this.language = language;}
    public void setWeight(double weight){this.weight = weight;}
    public void setSize(String size){this.size = size;}

}
