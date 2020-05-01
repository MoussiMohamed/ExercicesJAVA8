package com.hellokoding.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hellokoding.jpa.book.Author;
import com.hellokoding.jpa.book.AuthorRepository;
import com.hellokoding.jpa.book.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
//    @Autowired
//    private BookRepository bookRepository;

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
//    	Publisher publisher = new Publisher("Publisher 1");

//    	Author author = new Author("Author 1");
//    	
//    	Book book1 = new Book("Book 1");
//    	Book book2 = new Book("Book 2");
//    	
//    	book1.setAuthor(author);
//    	book2.setAuthor(author);
//    	
//    	author.getBooks().add(book1);
//    	author.getBooks().add(book2);

//    	authorRepository.save(author);
//    	create();

		// Create an Author
		Author author = new Author("Post 1");
		
		// Create many Books
		Book book1 = new Book("Book 1");
		book1.setAuthor(author);
		Book book2 = new Book("Book 2");
		book2.setAuthor(author);
		
		// Add Books in Author
		author.setBooks(Stream.of(book1, book2).collect(Collectors.toSet()));
		
		// Save Author and Books via the Author entity
		authorRepository.save(author);		

	}

	public void create() {
		List<Author> authors = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Author author = new Author("Author " + (i + 1));
			for (int j = 0; j < 2; j++) {
				Book book = new Book(String.format("Book %s.%s", (i + 1), (j + 1)));
				book.setAuthor(author);
			}
			authors.add(author);
		}

		authorRepository.saveAll(authors);
	}
}
