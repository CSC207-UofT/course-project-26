package EntityTest;

import main.entity.Book;
import main.entity.Listing;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ListingTest {
    private Book book;
    private Listing listing;

    @Before
    public void setUp() {
        book = new Book(
                20.00, "A Random Walk Down Wall Street", "Burton Malkiel", "W. W. Norton & Company, Inc.",
//                    2019,
                7, 432, "HardCover", "English", 2.5, "14-10-5"
        );
        listing = new Listing(book.getId(), 3);
    }

    @Test
    public void testgetBook() {
        assertEquals(book.getId(), listing.getBookId());
    }

    @Test
    public void testgetStatus() {
        assertEquals("Available", listing.getStatus());
    }

    @Test
    public void testaddBookToListing() {
        listing.addBookToListing(7);
        assertEquals(10, listing.getQuantity());
        assertEquals("Available", listing.getStatus());
    }

    @Test
    public void testremoveBookFromListing() {
        try {
            listing.removeBookFromListing(3);
        } catch (Exception e) { System.out.println("This quantity is not available to remove");
        }

        assertEquals(0, listing.getQuantity());
        assertEquals("Sold out", listing.getStatus());
    }
}
