package com.hellokoding.jpa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
//@EqualsAndHashCode(exclude = "books")
@Entity
@RequiredArgsConstructor
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NonNull
	private String name;

	@OneToMany(mappedBy = "publisher")
	private Set<BookPublisher> bookPublishers;

}
