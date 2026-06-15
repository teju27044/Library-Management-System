package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Book;
import in.sp.main.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(int id, Book book) {

        Book oldBook = repository.findById(id).orElse(null);

        if (oldBook != null) {

            oldBook.setTitle(book.getTitle());
            oldBook.setAuthor(book.getAuthor());
            oldBook.setPrice(book.getPrice());
            oldBook.setCategory(book.getCategory());
            oldBook.setImageUrl(book.getImageUrl());

            return repository.save(oldBook);
        }

        return null;
    }

    @Override
    public String deleteBook(int id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Book Deleted Successfully";
        }

        return "Book Not Found";
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return repository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        return repository.findByCategoryIgnoreCase(category);
    }
}