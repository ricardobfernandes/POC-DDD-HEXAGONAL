package com.ricardo.PoCLibrary.application.service;

import com.ricardo.PoCLibrary.application.port.in.FindBookUseCase;
import com.ricardo.PoCLibrary.application.port.out.BookRepository;
import com.ricardo.PoCLibrary.domain.model.Book;

public class FindBookService implements FindBookUseCase {

	private final BookRepository bookRepository;

	public FindBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book findById(Long id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}
}
