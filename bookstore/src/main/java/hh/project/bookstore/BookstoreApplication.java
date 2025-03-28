package hh.project.bookstore;

import hh.project.bookstore.domain.Book;
import hh.project.bookstore.domain.Category;
import hh.project.bookstore.repository.CategoryRepository;
import hh.project.bookstore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
	public CommandLineRunner demo(CategoryRepository categoryRepository, BookRepository bookrepository) {
    	return (args) -> {
        	Category fantasy = new Category("Fantasy");
        	Category scifi = new Category("Science Fiction");
			Category horror = new Category("Horror");
        	categoryRepository.saveAll(List.of(fantasy, scifi, horror));

        	Book book1 = (new Book("The Fellowship of the Ring", "J. R. R. Tolkien", 2012, "0007488300", 18.95, fantasy));
        	Book book2 = (new Book("Harry Potter: Prisoner of Azkaban", "J. K. Rowling", 1999, "9781408894644", 12.95, fantasy));
        	Book book3 = (new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 1993, "9780316029186", 12.99, horror));
			bookrepository.saveAll(List.of(book1, book2, book3));

        	System.out.println("Fetch all the categories");
        	categoryRepository.findAll().forEach(category -> {
            	System.out.println("Category [id=" + category.getId() + ", name=" + category.getName() + "]");
        	});

        	System.out.println("Fetch all the books");
        	bookrepository.findAll().forEach(book -> {
            	System.out.println("Book [id=" + book.getId() + ", title=" + book.getTitle() + ", author=" + book.getAuthor() +
                    	", publicationYear=" + book.getPublicationYear() + ", isbn=" + book.getIsbn() + ", price=" + book.getPrice() + "]");
			
					
        });
		logger.info("Books and categories added!");
    };
}
}