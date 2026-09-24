package com.ricardo.PoCLibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ricardo.PoCLibrary.application.port.in.CreateBookUseCase;
import com.ricardo.PoCLibrary.application.port.in.FindBookUseCase;
import com.ricardo.PoCLibrary.application.port.in.FindBooksUseCase;
import com.ricardo.PoCLibrary.application.port.out.BookRepository;
import com.ricardo.PoCLibrary.application.service.CreateBookService;
import com.ricardo.PoCLibrary.application.service.FindBookService;
import com.ricardo.PoCLibrary.application.service.FindBooksService;

@Configuration
public class BeanConfig {
	// Why does this class exist?
	// Services implement use cases, but they are not annotated with @Service.
	// This class tells Spring:
	// CreateBookUseCase -> CreateBookService(with bookRespository)
	// FindBookUseCase   -> FindBookService(with bookRespository)
	// FindBooksUseCase  -> FindBooksService(with bookRespository)
	// This keeps the application layer independent from Spring.
	// If the framework changes, this class will probably need to be adapted as well.

	@Bean CreateBookUseCase createBookUseCase(BookRepository bookRepository) {
		return new CreateBookService(bookRepository);
	}

	@Bean FindBooksUseCase findBooksUseCase(BookRepository bookRepository) {
		return new FindBooksService(bookRepository);
	}
	
	@Bean FindBookUseCase findBookUseCase(BookRepository bookRepository) {
		return new FindBookService(bookRepository);
	}
}
