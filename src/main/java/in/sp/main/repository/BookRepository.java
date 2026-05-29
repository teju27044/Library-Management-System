package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}