package com.ricardo.PoCLibrary.application.port.in;

import java.util.List;

import com.ricardo.PoCLibrary.domain.model.Book;

//A contract offered by the library application to list all books
public interface FindBooksUseCase {

	List<Book> findAll();
}
