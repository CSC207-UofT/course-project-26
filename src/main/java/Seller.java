import java.util.ArrayList;

public class Seller extends User{
    /**
     *
     * @param name
     * @param utorid
     * @param email
     * @param location
     * @param inventory
     */
    ArrayList<Book> inventory;

    public Seller(String name, String utorid, String email, String location){
        super(name, utorid, email, location);
    }

    public void add_book(Book book){
        this.inventory.add(book);
    }

    public void sell_book(Book book){
        this.inventory.remove(book);
    }

}
