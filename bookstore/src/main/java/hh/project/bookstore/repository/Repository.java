package hh.project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hh.project.bookstore.domain.Book;

public interface Repository extends JpaRepository<Book, Long> {
}