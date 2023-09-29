package com.example.OnlineLibrary.service;

import com.example.OnlineLibrary.exception.BookNotFoundException;
import com.example.OnlineLibrary.model.Book;
import com.example.OnlineLibrary.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Book addBook(Book book)
    {
        book.setBookCode(UUID.randomUUID().toString());
        return bookRepo.save(book);
    }

    public List<Book> listOfBooks()
    {
        return bookRepo.findAll();
    }
    public Book updateBook(Book book)
    {
        return bookRepo.save(book);
    }

    public Book findBookById(Long id)
    {
        return bookRepo.findBookById(id).orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " was not found"));
    }
    public void deleteBook(Long id)
    {
        Book book = findBookById(id);
        bookRepo.delete(book);
    }
}
