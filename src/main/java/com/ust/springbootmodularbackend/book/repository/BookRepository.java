package com.ust.springbootmodularbackend.book.repository;

import com.ust.springbootmodularbackend.book.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer>{
}
