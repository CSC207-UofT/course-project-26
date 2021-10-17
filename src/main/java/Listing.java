import java.util.HashMap;

public class Listing {
    private final String id;
    private HashMap<Book, Integer> listBooks; // key is a Book, value is product number
    private String status;

    //Initialize a listing
    public Listing(String id){
        this.id = id;
        this.listBooks = new HashMap<>();
        this.status = "Available";
}
    public String getListingId() { return this.id; }

    public HashMap<Book, Integer> getListingBook() { return this.listBooks; }

    public String getListingStatus() { return this.status; }

    public void setListingStatus(String status) { this.status = status; }

    public void addBookToListing(Book book, Integer quantity) {
        this.listBooks.put(book, quantity);
    }

    public void removeBookFromListing(Book book, Integer quantity) {
        this.listBooks.remove(book, quantity);
    }

}