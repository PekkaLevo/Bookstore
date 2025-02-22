package hh.project.bookstore;

import hh.project.bookstore.domain.Book;
import hh.project.bookstore.domain.Category;
import hh.project.bookstore.repository.CategoryRepository;
import hh.project.bookstore.repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
	public CommandLineRunner demo(CategoryRepository categoryRepository, Repository repository) {
    	return (args) -> {
        	Category scienceFiction = categoryRepository.save(new Category("Science Fiction"));
        	Category fantasy = categoryRepository.save(new Category("Fantasy"));
        	Category horror = categoryRepository.save(new Category("Horror"));

        	repository.save(new Book("The Fellowship of the Ring", "J. R. R. Tolkien", 2012, "0007488300", 18.95, scienceFiction));
        	repository.save(new Book("Harry Potter: Prisoner of Azkaban", "J. K. Rowling", 1999, "9781408894644", 12.95, fantasy));
        	repository.save(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 1993, "9780316029186", 12.99, horror));

        	System.out.println("Fetch all the categories");
        	categoryRepository.findAll().forEach(category -> {
            	System.out.println("Category [id=" + category.getId() + ", name=" + category.getName() + "]");
        	});

        	System.out.println("Fetch all the books");
        	repository.findAll().forEach(book -> {
            	System.out.println("Book [id=" + book.getId() + ", title=" + book.getTitle() + ", author=" + book.getAuthor() +
                    	", publicationYear=" + book.getPublicationYear() + ", isbn=" + book.getIsbn() + ", price=" + book.getPrice() + "]");
        });
    };
}
}