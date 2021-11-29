package main.service;

import main.entity.Book;

import java.util.List;

public interface BookService {
     List<Book> findAll();

     Book getBookByBookname(Integer bookID);

     void saveOrUpdate(Book book);

     void deleteByBookname(Integer bookID);

     Book createBook(double price, String name, String author);
}
