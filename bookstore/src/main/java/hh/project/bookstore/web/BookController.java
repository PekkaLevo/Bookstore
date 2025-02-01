package hh.project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/index")
    public String showIndex(Model model) {
        model.addAttribute("message", "This is the front page of the Bookstore!");
        return "index";
    }

}
