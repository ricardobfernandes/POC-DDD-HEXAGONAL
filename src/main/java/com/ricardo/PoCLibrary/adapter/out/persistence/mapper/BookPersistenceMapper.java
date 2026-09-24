package com.ricardo.PoCLibrary.adapter.out.persistence.mapper;

import com.ricardo.PoCLibrary.adapter.out.persistence.BookEntity;
import com.ricardo.PoCLibrary.domain.model.Book;
import com.ricardo.PoCLibrary.domain.model.Isbn;

public class BookPersistenceMapper {

	public static BookEntity toEntity(Book book) {
		return new BookEntity(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn().value());
	}

	public static Book toDomain(BookEntity entity) {
		return new Book(entity.getId(), entity.getTitle(), entity.getAuthor(), new Isbn(entity.getIsbn()));
	}
}

//Why does this class exist?
//Book = business object used by the domain.
//BookEntity = object used by JPA/database.
//This mapper translates between them so the domain does not know JPA exists.
