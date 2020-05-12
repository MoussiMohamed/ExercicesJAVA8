package com.hellokoding.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hellokoding.jpa.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{
}
