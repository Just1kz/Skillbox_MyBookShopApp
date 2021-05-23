package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.dto.Book;
import com.example.MyBookShopApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    public List<Book> findBookByTitle(String x) {
        return bookRepository.findAllByTitleLowerCase(x);
    }

    public List<Book> findBookByAuthor(String x) {
        return bookRepository.findBookByAuthor_LastNameLowerCase(x);
    }
}
