package com.ust.springbootmodularbackend.book.api;

import com.ust.springbootmodularbackend.book.model.Books;
import com.ust.springbootmodularbackend.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Books> addBooks(@RequestBody Books book){
        Books body = bookService.saveBooks(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping
    public ResponseEntity<List<Books>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
