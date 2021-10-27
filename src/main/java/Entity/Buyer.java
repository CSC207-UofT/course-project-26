package Entity;

import java.util.ArrayList;

public class Buyer extends User{
    /**
     *
     * @param shoppingcart  The shopping cart stores all the books buyer want to buy
     */

    ArrayList<Book> shoppingcart;

    public Buyer(String name, String utorid, String email, String password, String location){
        super(name, utorid, email, password, location);
    }

    public void add_shoppingcart(Book book){
        this.shoppingcart.add(book);
    }

    public void delete_shoppingcart(Book book){
        this.shoppingcart.remove(book);
    }

    public double total_pay(){
        double pay = 0;
        for (Book book: this.shoppingcart){
            pay = pay + book.getPrice();
        }
        return pay;}
}
