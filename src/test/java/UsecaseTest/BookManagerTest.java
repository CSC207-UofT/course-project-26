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
                20.00, "A Random Walk Down Wall Street", "Burton Malkiel", "W. W. Norton & Company, Inc.",
//                    2019,
                7, 432, "HardCover", "English", 2.5, "14-10-5"
        );
        Book book2  = new Book(
                40.00, "Harry Potter and the Philosopher's Stone", "J.K Rowling", "Bloomsbury Publishing",
//                    2019,
                1, 223, "HardCover", "English", 2.5, "14-10-5");

        List<Book> l1 = new ArrayList<Book>();
        l1.add(book1);
        l1.add(book2);

        wes = new BookManager(l1);
        assertEquals("A Random Walk Down Wall Street", book1.getName());
        assertEquals(book1, wes.findBookById(book1.getName()));
        assertEquals(book1.getName(), wes.getBookNameById(book1.getName()));

    }
}


