package com.ricardo.PoCLibrary.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ricardo.PoCLibrary.adapter.out.persistence.mapper.BookPersistenceMapper;
import com.ricardo.PoCLibrary.application.port.out.BookRepository;
import com.ricardo.PoCLibrary.domain.exception.BookNotFoundException;
import com.ricardo.PoCLibrary.domain.model.Book;

@Repository
public class BookPersistenceAdapter implements BookRepository {
	// Why does this class exist?
	// The application depends on the BookRepository interface.
	// This adapter fulfills that contract using Spring Data JPA.
	// If JPA is replaced tomorrow, only this adapter should change.
	
	private final BookJpaRepository jpaRepository;

	public BookPersistenceAdapter(BookJpaRepository jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public Book save(Book book) {
		BookEntity entity = BookPersistenceMapper.toEntity(book);
		BookEntity savedEntity = jpaRepository.save(entity);
		return BookPersistenceMapper.toDomain(savedEntity);
	}

	@Override
	public List<Book> findAll() {
		return jpaRepository.findAll().stream().map(BookPersistenceMapper::toDomain).toList();
	}
	
	@Override
	public Book findById(Long id) {
	    BookEntity entity = jpaRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
	    return BookPersistenceMapper.toDomain(entity);
	}

	@Override
	public Book findByIsbn(String isbn) {
	    BookEntity entity = jpaRepository.findByIsbn(isbn).orElseThrow(() -> new BookNotFoundException("Book not found"));
	    return BookPersistenceMapper.toDomain(entity);
	}
}
