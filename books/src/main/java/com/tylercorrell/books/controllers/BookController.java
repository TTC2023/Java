package com.tylercorrell.books.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tylercorrell.books.models.Book;
import com.tylercorrell.books.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		
		Book book = bookService.findBook(id);
		
		model.addAttribute("book", book);

		return "show.jsp";
	}
	
	    
	    public void BooksController(BookService bookService) {
	        this.bookService = bookService;
	    }
	    
	    @GetMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "/index.jsp";
	    }
	}