package com.hellokoding.jpa;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hellokoding.jpa.book.Author;
import com.hellokoding.jpa.book.AuthorRepository;
import com.hellokoding.jpa.book.Book;
import com.hellokoding.jpa.book.Publisher;
import com.hellokoding.jpa.book.PublisherRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Create an Author
//    	Author author = authorRepository.save(new Author("Med Author"));
		// Create a couple of Book and Publisher
//        bookRepository.save(new Book("Book 1", new Author("MED 2"), new Publisher("Publisher A"), new Publisher("Publisher B")));
		Publisher publisher1 = new Publisher("Publisher 1");
		Publisher publisher2 = new Publisher("Publisher 2");

		// Create an Author
		Author author = new Author("Author 1");

		// Create many Books
		Book book1 = new Book("Book 1", publisher1);
		book1.setAuthor(author);
		Book book2 = new Book("Book 2", publisher2);
		book2.setAuthor(author);

		// Add Books in Author
		author.setBooks(Stream.of(book1, book2).collect(Collectors.toSet()));

		// Save Author and Books via the Author entity
		authorRepository.save(author);

	}
}
