package main.service.impl;

import main.entity.Book;
import main.entity.User;
import main.repository.BookRepository;
import main.repository.UserRepository;
import main.service.BookService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A service class that performs student-related activity.
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);

        return books;
    }

    @Override
    public Book getBookByBookname(Integer bookID) {
        return bookRepository.findById(bookID).orElse(null);
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteByBookname(Integer bookID) {
        bookRepository.deleteById(bookID);
    }

    @Override
    public Book createBook(double price, String name, String author) {
        Book book = new Book(price, name, author);

        return book;
    };

}
