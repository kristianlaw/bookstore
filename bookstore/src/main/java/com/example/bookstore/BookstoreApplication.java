package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.domain.Book;
import com.example.bookstore.model.domain.BookRepository;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		Book a = new Book("Harry Potter", "J.K Rowlings", 101010, 2009, 20);
		Book b = new Book("Aku Ankka", "Don Rosa", 202020, 2005, 5);
		Book c = new Book("Raamattu", "Multiple authors", 303030, 1, 5);
		
		repository.save(a);
		repository.save(b);
		repository.save(c);
	};
	}

}
