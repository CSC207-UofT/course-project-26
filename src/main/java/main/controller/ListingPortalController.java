package main.controller;

import main.entity.Book;
import main.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ListingPortalController {

    @Autowired
    private BookService bookService;

    public  List<Book> getAllBooks() {
        return bookService.findAll();
    }

    public void sell(String username, double price, String name, String author) {

        Book new_book = bookService.createBook(price, name, author);
        new_book.setUser(username);
        bookService.saveOrUpdate(new_book);

    }

}
