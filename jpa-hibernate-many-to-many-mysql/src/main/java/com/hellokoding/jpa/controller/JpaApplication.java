package com.hellokoding.jpa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hellokoding.jpa.model.Book;
import com.hellokoding.jpa.model.BookPublisher;
import com.hellokoding.jpa.model.Publisher;
import com.hellokoding.jpa.repository.AuthorRepository;
import com.hellokoding.jpa.repository.BookRepository;
import com.hellokoding.jpa.repository.PublisherRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
//@EnableJpaAuditing
//@ComponentScan({"com.hellokoding.jpa"})
@EntityScan("com.hellokoding.jpa.model")
@EnableJpaRepositories("com.hellokoding.jpa.repository")
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
//	@Transactional
	public void run(String... args) {
		// Create an Author
//    	Author author = authorRepository.save(new Author("Med Author"));
		// Create a couple of Book and Publisher
//        bookRepository.save(new Book("Book 1", new Author("MED 2"), new Publisher("Publisher A"), new Publisher("Publisher B")));
//		Publisher publisher1 = new Publisher("Publisher 1");
//		Publisher publisher2 = new Publisher("Publisher 2");

		// Create an Author
//		Author author = new Author("Author 1");

		// Create many Books
//		Book book1 = new Book("Book 1", publisher1);
//		book1.setAuthor(author);
//		Book book2 = new Book("Book 2", publisher2);
//		book2.setAuthor(author);

		// Add Books in Author
//		author.setBooks(Stream.of(book1, book2).collect(Collectors.toSet()));
//
//		// Save Author and Books via the Author entity
//		authorRepository.save(author);
		
		Book bookA = new Book("Book A");
		Publisher publisherA = new Publisher("Publisher A");
		
		BookPublisher bookPublisher = new BookPublisher();
		bookPublisher.setBook(bookA);
		bookPublisher.setPublisher(publisherA);
		bookPublisher.setPublishedDate(new Date());
		
		bookA.getBookPublishers().add(bookPublisher);
		
		publisherRepository.save(publisherA);
		bookRepository.save(bookA);

	}
}
