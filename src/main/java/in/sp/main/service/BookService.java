package in.sp.main.service;

import java.util.List;

import in.sp.main.entity.Book;

public interface BookService {

    // Add Book
    Book saveBook(Book book);

    // Get All Books
    List<Book> getAllBooks();

    // Get Book By Id
    Book getBookById(int id);

    // Update Book
    Book updateBook(int id, Book book);

    // Delete Book
    String deleteBook(int id);

    // Search By Title
    List<Book> searchByTitle(String title);

    // Search By Author
    List<Book> searchByAuthor(String author);

    // Filter By Category
    List<Book> getBooksByCategory(String category);
}