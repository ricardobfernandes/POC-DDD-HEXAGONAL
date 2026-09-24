package com.ricardo.PoCLibrary.domain.model;

import com.ricardo.PoCLibrary.domain.exception.InvalidBookInfoException;

//Hexagonal Architecture:
//The domain is the center of the application.
//This class contains business rules and does not know anything about Spring, JPA or HTTP.
public class Book {

	private Long id;
	private String title;
	private String author;
	private Isbn isbn;

	public Book(Long id, String title, String author, Isbn isbn) {
		if (title == null || title.isBlank()) {
			throw new InvalidBookInfoException("Title is required");
		}
		if (author == null || author.isBlank()) {
			throw new InvalidBookInfoException("Author is required");
		}
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Isbn getIsbn() {
		return isbn;
	}
}