package com.ricardo.PoCLibrary.adapter.in.web.mapper;

import com.ricardo.PoCLibrary.adapter.in.web.dto.BookResponse;
import com.ricardo.PoCLibrary.adapter.in.web.dto.CreateBookRequest;
import com.ricardo.PoCLibrary.domain.model.Book;
import com.ricardo.PoCLibrary.domain.model.Isbn;

public class BookMapper {

	public static Book toDomain(CreateBookRequest request) {
		return new Book(null, request.title(), request.author(), new Isbn(request.isbn()));
	}

	public static BookResponse toResponse(Book book) {
		return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn().value());
	}
	// Responsible for converting DTOs to domain objects and vice versa.
}
