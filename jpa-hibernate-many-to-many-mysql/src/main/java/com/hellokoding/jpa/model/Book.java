package com.hellokoding.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(exclude = "author")
@Entity
public class Book extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NonNull
	private String name;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "book_publisher",
//		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
//		inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
//	private Set<Publisher> publishers = new HashSet<>();
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BookPublisher> bookPublishers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

	public Book(String name/*, Publisher... publishers*/) {
		this.name = name;
//		this.publishers = Stream.of(publishers).collect(Collectors.toSet());
//		this.publishers.forEach(x -> x.getBooks().add(this));
		bookPublishers = new HashSet<>();
	}

}
