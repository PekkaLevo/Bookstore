package hh.project.bookstore.repository;

import hh.project.bookstore.domain.Book;
import hh.project.bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(Category category);
}