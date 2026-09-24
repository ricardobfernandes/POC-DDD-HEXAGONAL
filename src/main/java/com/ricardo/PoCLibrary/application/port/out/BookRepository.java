package com.ricardo.PoCLibrary.application.port.out;

import java.util.List;
import com.ricardo.PoCLibrary.domain.model.Book;

//Hexagonal Architecture:
//Output port used by the application.
//The application knows only this contract and does not know whether data is stored using JPA, MongoDB, files or another technology.
public interface BookRepository {

	Book save(Book book);

	List<Book> findAll();
	
	Book findById(Long id);
	
	Book findByIsbn(String isbn);
}
