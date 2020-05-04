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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(exclude = "author")

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NonNull
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_publisher",
		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
	private Set<Publisher> publishers = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

	public Book(String name, Publisher... publishers) {
		this.name = name;
		this.publishers = Stream.of(publishers).collect(Collectors.toSet());
		this.publishers.forEach(x -> x.getBooks().add(this));
	}

}
