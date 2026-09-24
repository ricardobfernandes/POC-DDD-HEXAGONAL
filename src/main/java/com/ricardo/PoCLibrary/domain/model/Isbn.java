package com.ricardo.PoCLibrary.domain.model;

import com.ricardo.PoCLibrary.domain.exception.InvalidIsbnException;

//Value Object that encapsulates ISBN validation.
//The Book entity relies on this object instead of validating ISBN directly.
public record Isbn(String value) {

    public Isbn {

        if (value == null || value.isBlank()) {
            throw new InvalidIsbnException("ISBN is required");
        }

        if (value.length() < 10) {
            throw new InvalidIsbnException("Invalid ISBN");
        }
    }
}
