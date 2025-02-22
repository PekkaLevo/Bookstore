package hh.project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import hh.project.bookstore.repository.Repository;
import hh.project.bookstore.domain.Book;
import hh.project.bookstore.repository.CategoryRepository;

@Controller
public class BookController {

    private final Repository repository;
    private final CategoryRepository categoryRepository;

    public BookController(Repository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("message", "This is the front page of the Bookstore!");
        return "index";
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> books = repository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/editbook/{id}")
    public String showEditBookForm(@PathVariable long id, Model model) {
        Book book = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book ID:" + id));
        model.addAttribute("book", book);
        return "editbook";
    }

    @PostMapping("/editbook/{id}")
    public String updateBook(@PathVariable long id, @ModelAttribute Book book) {
        book.setId(id);
        repository.save(book);
        return "redirect:/booklist";
    }
}

