package Entity;

import java.util.UUID;


public class Listing {
    /**
     * Listing is an entity
     *
     * id: The unique identifier of the listing.
     * book:
     * description: The description of the item.
     * status: The status of the item in terms of availability.
     */
    private final String id;
    private final String book;
    private int quantity;
    private boolean isSold;

    //Initialize a listing
    public Listing(String bookId, int quantity){
        UUID inputId = UUID.randomUUID();  // creates a UUID at instantiation
        this.id = String.valueOf(inputId); // TODO: Check if it creates the same id again in another instantiation
        this.book = bookId;
        this.quantity = quantity;
        this.isSold = quantity == 0;
    }

    /*
     * Get the id of the Listing.
     *
     * @return the ListingId.
     */
    public String getListingId() { return this.id; }

    /*
     * Get the book in the Listing.
     *
     * @return the Book in the Listing.
     */
    public String getBook() { return this.book; }

    /*
     * Get whether the book in the listing is available or sold out.
     *
     * @return "Available" or "Sold out" depending on the availability of the book.
     */
    public String getListingStatus() {
        if (this.isSold) {
            return "Sold out";
        }
        else {
            return "Available";
        }
    }

    /*
     * Add the quantity number of books to the Listing
     *
     * @param quantity the number of books to be added
     */
    public void addBookToListing(int quantity) {
        if (quantity > 0) {
            if (this.quantity == 0) {
                this.isSold = true;
            }
            this.quantity += quantity;
        }
    }
    /*
    * Removes the quantity number of books from the Listing
    *
    * @param quantity the number of books to be removed
     */
    public void removeBookFromListing(int quantity) throws Exception {
        if (this.quantity - quantity < 0) {
            throw new Exception("This quantity is not available to remove");
        }
        else if (this.quantity - quantity == 0) {
            this.isSold = true;
            this.quantity = 0;
        }
        else {
            this.quantity -= quantity;
        }
    }

}