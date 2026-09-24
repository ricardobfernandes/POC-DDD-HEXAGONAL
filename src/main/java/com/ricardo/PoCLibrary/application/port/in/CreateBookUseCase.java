package com.ricardo.PoCLibrary.application.port.in;

import com.ricardo.PoCLibrary.domain.model.Book;

//Hexagonal Architecture:
//Input port used by external adapters to create books.
//Controllers depend on this contract instead of concrete services.
public interface CreateBookUseCase {

	Book create(Book book);
}
