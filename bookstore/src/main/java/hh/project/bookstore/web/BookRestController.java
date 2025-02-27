package hh.project.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import hh.project.bookstore.domain.Book;
import hh.project.bookstore.repository.BookRepository;

@CrossOrigin
@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getBookById(@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PostMapping("/books")
    public @ResponseBody Book addNewBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }
}