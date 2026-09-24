package com.ricardo.PoCLibrary.application.port.in;

import com.ricardo.PoCLibrary.domain.model.Book;

//A contract offered by the library application to find a specific book
public interface FindBookUseCase {

	Book findById(Long id);
	
	Book findByIsbn(String isbn);
}
