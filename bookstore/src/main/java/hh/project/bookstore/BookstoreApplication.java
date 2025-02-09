package hh.project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.project.bookstore.domain.Book;
import hh.project.bookstore.repository.Repository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(Repository repository) {
		return (args) -> {
			repository.save(new Book("The Fellowship of the Ring: Book 1 (The Lord of the Rings)", "J. R. R. Tolkien", 2012, "0007488300", 18.95));
			repository.save(new Book("Harry Potter: Prisoner of Azkaban", "J. K. Rowling", 1999, "9781408894644", 12.95));
			repository.save(new Book("The Last Wish: Introducing the Witcher", "Andrzej Sapkowski", 1993,"9780316029186", 12.99));
		
			repository.findAll().forEach(book -> {
				System.out.println(book);
			});
			System.out.println("Books added!");
		};
	}
}
