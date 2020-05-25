package com.hellokoding.jpa.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.hellokoding.jpa.model.Book;

public interface BookService {
	
	List<Book> getAllBooks();
	
	Book getBook(@NotNull int bookId);
	
	Book createBook(@NotNull Book book);
	
	Book updateBook(@NotNull int bookId);

}
