package com.ricardo.PoCLibrary.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
	// Hexagonal Architecture:
	// Only the persistence adapter knows Spring Data JPA.
	// The application layer only knows the BookRepository port.
	
	Optional<BookEntity> findByIsbn(String isbn);
	
}
