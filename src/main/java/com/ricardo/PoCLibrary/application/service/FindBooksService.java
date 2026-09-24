package com.ricardo.PoCLibrary.application.service;

import java.util.List;

import com.ricardo.PoCLibrary.application.port.in.FindBooksUseCase;
import com.ricardo.PoCLibrary.application.port.out.BookRepository;
import com.ricardo.PoCLibrary.domain.model.Book;

public class FindBooksService implements FindBooksUseCase {

	private final BookRepository bookRepository;

	public FindBooksService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

}
