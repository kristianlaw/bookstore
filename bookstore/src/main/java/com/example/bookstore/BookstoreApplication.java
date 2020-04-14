package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.domain.Book;
import com.example.bookstore.model.domain.BookRepository;
import com.example.bookstore.model.domain.Category;
import com.example.bookstore.model.domain.CategoryRepository;
import com.example.bookstore.model.domain.User;
import com.example.bookstore.model.domain.UserRepository;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		
		crepository.save(new Category("Fiction"));
		crepository.save(new Category("Fact"));
		crepository.save(new Category("Fantasy"));
		
		brepository.save(new Book("Harry Potter", "J.K Rowlings", 101010, 2009, 20, crepository.findByName("Fantasy").get(0)));
		brepository.save(new Book("Aku Ankka", "Don Rosa",  202020, 2005, 5, crepository.findByName("Fiction").get(0)));
		brepository.save(new Book("Raamattu", "Multiple authors", 303030, 1, 5, crepository.findByName("Fact").get(0)));
		
		User userYksi = new User("user", "$2y$12$4iGWyQs5hC6ibe5Pq7ochekppUZcSfeIV.tjgZIuSobVA8B5vOhXK", "USER");
				//Molemmat salasanat hashattu BCryptillä, roundit oli 12 ja 9 
		User userKaksi = new User("admin", "$2y$06$K9UJzObPGyroQKlkTzWWz.BlUurpYCMFelyvM/2AVYSbzogvd3.zq", "ADMIN");
				 
		
		urepository.save(userYksi);
		urepository.save(userKaksi);
		
		/*Object log;
		log.info("fetch all books");
		for (Book book : brepository.findAll()) {
			log.info(book.toString());*/
	//}

	};
	}
}
