package com.ricardo.PoCLibrary.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ricardo.PoCLibrary.application.port.out.BookRepository;
import com.ricardo.PoCLibrary.domain.model.Book;
import com.ricardo.PoCLibrary.domain.model.Isbn;

@Configuration
public class TestConfig {

	@Bean
	CommandLineRunner loadDatabase(BookRepository bookRepository) {

		return ignored -> {
			bookRepository.save(new Book(null, "Clean Code", "Robert C. Martin", new Isbn("9780132350884")));
			bookRepository.save(new Book(null, "Effective Java", "Joshua Bloch", new Isbn("9780134685991")));
			bookRepository.save(new Book(null, "Domain-Driven Design", "Eric Evans", new Isbn("9780321125217")));
			bookRepository.save(new Book(null, "Refactoring", "Martin Fowler", new Isbn("9780134757599")));
			bookRepository.save(new Book(null, "Clean Architecture", "Robert C. Martin", new Isbn("9780134494166")));
		};
	}
}