package in.sp.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // Search books by title
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Search books by author
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Filter by category
    List<Book> findByCategoryIgnoreCase(String category);

}