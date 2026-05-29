package in.sp.main.service;

import java.util.List;

import in.sp.main.entity.Book;

public interface BookService {

    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book updateBook(int id, Book book);

    String deleteBook(int id);
}