package com.ricardo.PoCLibrary.adapter.in.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.PoCLibrary.adapter.in.web.dto.BookResponse;
import com.ricardo.PoCLibrary.adapter.in.web.dto.CreateBookRequest;
import com.ricardo.PoCLibrary.adapter.in.web.mapper.BookMapper;
import com.ricardo.PoCLibrary.application.port.in.CreateBookUseCase;
import com.ricardo.PoCLibrary.application.port.in.FindBookUseCase;
import com.ricardo.PoCLibrary.application.port.in.FindBooksUseCase;
import com.ricardo.PoCLibrary.domain.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	// Hexagonal Architecture:
	// Input adapter responsible for receiving HTTP requests.
	// The controller depends on use cases only.
	// Business rules do not depend on Spring, HTTP or this controller.

	private final CreateBookUseCase createBookUseCase;
	private final FindBooksUseCase findBooksUseCase;
	private final FindBookUseCase findBookUseCase;

	public BookController(CreateBookUseCase createBookUseCase, FindBooksUseCase findBooksUseCase,
			FindBookUseCase findBookUseCase) {
		this.createBookUseCase = createBookUseCase;
		this.findBooksUseCase = findBooksUseCase;
		this.findBookUseCase = findBookUseCase;
	}

	@PostMapping
	public BookResponse create(@RequestBody CreateBookRequest request) {
		Book book = BookMapper.toDomain(request);
		Book createdBook = createBookUseCase.create(book);
		return BookMapper.toResponse(createdBook);
	}

	@GetMapping
	public List<BookResponse> findAll() {
		return findBooksUseCase.findAll().stream().map(BookMapper::toResponse).toList();
	}

	@GetMapping("/{id}")
	public BookResponse findById(@PathVariable Long id) {
		Book book = findBookUseCase.findById(id);
		return BookMapper.toResponse(book);
	}

	@GetMapping("/isbn/{isbn}")
	public BookResponse findByIsbn(@PathVariable String isbn) {
		Book book = findBookUseCase.findByIsbn(isbn);
		return BookMapper.toResponse(book);
	}
}
