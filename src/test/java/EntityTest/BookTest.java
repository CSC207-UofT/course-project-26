package EntityTest;

import main.entity.Account;
import main.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BookTest {
        private Book book;
        @Before
        public void setUp(){
            book = new Book(
                20.00, "A Random Walk Down Wall Street", "Burton Malkiel", "W. W. Norton & Company, Inc.",
//                    2019,
                    7, 432, "HardCover", "English", 2.5, "14-10-5"
            );
        }

        @Test
        public void testgetPrice(){
            assertEquals(20.00, book.getPrice(), 0.00);
        }

        @Test
        public void testgetName(){
            assertEquals("A Random Walk Down Wall Street", book.getName());
        }

        @Test
        public void testgetLanguage(){
            assertEquals("English", book.getLanguage());
        }

        @Test
        public void testsetPrice() {
            book.setPrice(4.79);
            assertEquals(4.79, book.getPrice(), 0.00);
        }

        @Test
        public void testsetPages() {
            book.setPages(379);
            assertEquals(379, book.getPages(), 0.00);
        }

        @Test
        public void testChangePassword() {
            assertEquals(book.getBookInfo(), Arrays.asList(
                    book.getId(),
                    book.getPrice(),
                    book.getName(),
                    book.getAuthor(),
                    book.getPublisher(),
//                    book.getPub_date(),
                    book.getEdition(),
                    book.getPages(),
                    book.getFormat(),
                    book.getLanguage(),
                    book.getWeight(),
                    book.getSize()));
        }
    }

