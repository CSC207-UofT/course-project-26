package UsecaseTest;

import main.usecase.BookManager;
import main.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookManagerTest {
    BookManager wes;

    @Test
    public void test_id_management(){
        Book book1  = new Book(
                20.00, "A Random Walk Down Wall Street", "Burton Malkiel");
        Book book2  = new Book(
                40.00, "Harry Potter and the Philosopher's Stone", "J.K Rowling");

        List<Book> l1 = new ArrayList<Book>();
        l1.add(book1);
        l1.add(book2);

        wes = new BookManager(l1);
        assertEquals("A Random Walk Down Wall Street", book1.getName());

    }
}


