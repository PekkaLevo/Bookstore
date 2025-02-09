package hh.project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}

