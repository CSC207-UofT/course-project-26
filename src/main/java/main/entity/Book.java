package main.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.io.Serializable;

@Entity
public class Book implements Serializable{

    /**
     * Construct a Main.ConsoleUI.Entity.Book with the following instance attributes:
     *
     *  id: The unique identifier of the Main.ConsoleUI.Entity.Book
     *  name: The name of the Main.ConsoleUI.Entity.Book
     *  author: The author of the Main.ConsoleUI.Entity.Book
     *  publisher: The publisher of the Main.ConsoleUI.Entity.Book
     *  pub_date: The publish date of the Main.ConsoleUI.Entity.Book in ...  with the format yyyy-MM-dd in string
     *  edition: The edition of the Main.ConsoleUI.Entity.Book
     *  pages: The number of pages in the Main.ConsoleUI.Entity.Book
     *  format: The format of the Main.ConsoleUI.Entity.Book. It can be either one of "Paperback", "Hardcover", "Looseleaf",
     *          "Online code"
     *  language: The language of the Main.ConsoleUI.Entity.Book
     *  weight: The weight of the Main.ConsoleUI.Entity.Book in kilograms. Default value is N/A
     *  size: The dimensions of the Main.ConsoleUI.Entity.Book. It is stored in the format of
     *      "14-10-4" (length-width-height) in meters. Each value is separated with the '-' symbol.
     *      Default value is N/A. TODO: Decide how to store dimensions
     */

    @Id
    private String id;

    @Column
    private double price;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String publisher;

//    private DateTimeFormatter pub_date;

    @Column
    private int edition;

    @Column
    private int pages;

    @Column
    private String format;

    @Column
    private String language;

    @Column
    private double weight;

    @Column
    private String size;

    /**
     * Constructor for "Book."
     */
    public Book(double price, String name, String author, String publisher,
//                String pub_date,
                int edition, int pages, String format, String language, double weight, String size) {
        UUID inputId = UUID.randomUUID();
        this.id = String.valueOf(inputId);
        this.price = price;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
//        this.pub_date = DateTimeFormatter.ofPattern(pub_date);
        this.edition = edition;
        this.pages = pages;
        this.format = format;
        this.language = language;
        this.weight = weight;
        this.size = size;
    }

    /**
     * Constructor for "Book" with missing weight and size values.
     */
    public Book(double price, String name, String author, String publisher,
//                String pub_date,
                int edition, int pages, String format, String language) {
        UUID inputId = UUID.randomUUID();
        this.id = String.valueOf(inputId);
        this.price = price;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        //        this.pub_date = DateTimeFormatter.ofPattern(pub_date);
        this.edition = edition;
        this.pages = pages;
        this.format = format;
        this.language = language;
        this.weight = 0;
        this.size = null;
    }

    /**
     * Constructor for "Book" with missing edition, pages, format, language, weight, size values.
     */
    public Book(double price, String name, String author, String publisher
//                , String pub_date
    ) {
        UUID inputId = UUID.randomUUID();
        this.id = String.valueOf(inputId);
        this.price = price;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        //        this.pub_date = DateTimeFormatter.ofPattern(pub_date);
        this.edition = 0;
        this.pages = 0;
        this.format = null;
        this.language = null;
        this.weight = 0;
        this.size = null;
    }

    public Book() {

    }

    /**
     * Get the Main.ConsoleUI.Entity.Book info in a list.
     *
     * @return a list of the information stored in the Main.ConsoleUI.Entity.Book class.
     */
    public List<Object> getBookInfo() {
        return Arrays.asList(
                this.id,
                this.price,
                this.name,
                this.author,
                this.publisher,
//                this.pub_date,
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
//    public String getPub_date(){return this.pub_date.toString();}
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
//    public void setPub_date(String pub_date){this.pub_date = DateTimeFormatter.ofPattern(pub_date);}
    public void setEdition(int edition){this.edition = edition;}
    public void setPages(int pages){this.pages = pages;}
    public void setFormat(String format){this.format = format;}
    public void setLanguage(String language){this.language = language;}
    public void setWeight(double weight){this.weight = weight;}
    public void setSize(String size){this.size = size;}

}
