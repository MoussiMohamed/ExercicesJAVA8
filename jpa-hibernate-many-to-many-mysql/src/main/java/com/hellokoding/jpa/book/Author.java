package com.hellokoding.jpa.book;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

//@Data
@Entity(name = "Author")
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(
			mappedBy = "author", 
			cascade = CascadeType.PERSIST, 
			fetch = FetchType.LAZY)
	private Set<Book> books;

	public Author() {
	}

	public Author(String name) {
		this.name = name;
		books = new HashSet<>();
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
		for (Book book : books) {
			book.setAuthor(this);
		}
	}

//	public Author(String name, Book... books) {
//		this.name = name;
//		this.books = Stream.of(books).collect(Collectors.toSet());
//		this.books.forEach(book -> book.setAuthor(this));
//	}

//	public Set<Book> getBooks() {
//		return books;
//	}
//	
//	public void setBooks(Set<Book> books) {
//		this.books = books;
//		for (Book book : books) {
//			book.setAuthor(this);
//		}
//	}

}
