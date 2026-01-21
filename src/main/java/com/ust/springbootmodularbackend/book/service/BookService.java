package com.ust.springbootmodularbackend.book.service;

import com.ust.springbootmodularbackend.book.model.Books;
import com.ust.springbootmodularbackend.book.repository.BookRepository;
import com.ust.springbootmodularbackend.book.exceptions.BookNotFoundException;
import com.ust.springbootmodularbackend.book.exceptions.DuplicateBookFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Books saveBooks(Books book){
        if(bookRepository.existsById(book.getId())){
            throw new DuplicateBookFoundException("The book with id: " + book.getId() + " already exists!");
        }
        return bookRepository.save(book);
    }

    public List<Books> getBooks(){
        return bookRepository.findAll();
    }

    public Books getBookById(Integer id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book with id: " + id + " doesn't exist!"));
    }

    public void deleteBook(Integer id){
        Books book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book with id: " + id + " doesn't exist!"));
        bookRepository.delete(book);
    }

}
