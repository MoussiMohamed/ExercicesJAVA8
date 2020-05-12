package com.hellokoding.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name = "book_publisher")
@EqualsAndHashCode(exclude = "book")
@Entity
public class BookPublisher implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name ="book_id")
	private Book book;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@Column(name = "published_date")
	private Date publishedDate;
}
