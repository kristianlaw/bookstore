package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.domain.Book;
import com.example.bookstore.model.domain.BookRepository;
import com.example.bookstore.model.domain.Category;
import com.example.bookstore.model.domain.CategoryRepository;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
	return (args) -> {
		
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("Fact"));
		crepository.save(new Category("Fantasy"));
		
		brepository.save(new Book("Harry Potter", "J.K Rowlings", 101010, 2009, 20, crepository.findByName("Fantasy").get(0)));
		brepository.save(new Book("Aku Ankka", "Don Rosa",  202020, 2005, 5, crepository.findByName("Fiction").get(0)));
		brepository.save(new Book("Raamattu", "Multiple authors", 303030, 1, 5, crepository.findByName("Fact").get(0)));
		
	
		
		Object log;
		log.info("fetch all books");
		for (Book book : brepository.findAll()) {
			log.info(book.toString());
	}

	};
	}
}
