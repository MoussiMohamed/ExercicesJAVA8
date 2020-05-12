package com.hellokoding.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hellokoding.jpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
}
