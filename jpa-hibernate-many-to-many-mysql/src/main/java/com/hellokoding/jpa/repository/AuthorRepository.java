package com.hellokoding.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hellokoding.jpa.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
