package dev.tulasidhar.lms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.tulasidhar.lms.model.Book;
import dev.tulasidhar.lms.service.BookService;
import dev.tulasidhar.lms.service.impl.BookServiceImpl;

@RestController
public class BookController {
	BookService bookService;
	
	public BookController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		bookService = new BookServiceImpl();
	}
	
	
	@GetMapping(value="/getallbooks",produces = "application/json")
	public List<Book> getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		return books;
	}
	
}
