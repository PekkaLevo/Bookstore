package hh.project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import hh.project.bookstore.repository.Repository;
import hh.project.bookstore.domain.Book;

@Controller
public class BookController {

    private final Repository repository;

    public BookController(Repository repository) {
        this.repository = repository;
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
}

