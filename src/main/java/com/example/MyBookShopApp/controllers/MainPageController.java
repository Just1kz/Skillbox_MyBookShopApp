package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.books.Book;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Comparator;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;


    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        List<Book> rsl = bookService.getBooksData();
        rsl.sort(Comparator.naturalOrder());
        return rsl;
    }

    @GetMapping("/main")
    public String mainPage() {
        return "/mapping/main/index";
    }
}
