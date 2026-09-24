package com.ricardo.PoCLibrary.application.service;

import com.ricardo.PoCLibrary.application.port.in.CreateBookUseCase;
import com.ricardo.PoCLibrary.application.port.out.BookRepository;
import com.ricardo.PoCLibrary.domain.model.Book;

public class CreateBookService implements CreateBookUseCase {
	// Hexagonal Architecture:
	// The controller calls this service through the use case interface.
	// This class knows only the BookRepository port.
	// The implementation details of persistence are hidden behind the port.
	
	    private final BookRepository bookRepository;

	    public CreateBookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }

	    @Override
	    public Book create(Book book) {
	        return bookRepository.save(book);
	    }
}
