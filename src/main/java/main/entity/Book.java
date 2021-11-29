package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
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
    private String username;

    /**
     * Constructor for "Book."
     */
    public Book(double price, String name, String author) {
        UUID inputId = UUID.randomUUID();
        this.id = String.valueOf(inputId);
        this.price = price;
        this.name = name;
        this.author = author;
        this.username = null;
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
                this.author);
    }
    //getter methods start here...
    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public String getAuthor(){return this.author;}
    public double getPrice(){return this.price;}
    public String getUser(){return this.username;}

    // setter methods start here...
    public void setId(String id) {this.id = id;}
    public void setPrice(double price) {this.price = price;}
    public void setName(String name){this.name = name;}
    public void setAuthor(String author){this.author = author;}
    public void setUser(String username){this.username = username;}

    public String toString(){
        return "The book named '" +this.getName() + "' by the author '" + this.getAuthor() + "' is currently listed " +
                "for a price of " + this.getPrice();
    }

}
