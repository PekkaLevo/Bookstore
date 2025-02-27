package hh.project.bookstore.repository;

import hh.project.bookstore.domain.Book;
import hh.project.bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(Category category); 
}