package dev.tulasidhar.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.tulasidhar.lms.Exceptions.DBConstrainsException;
import dev.tulasidhar.lms.model.Book;
import dev.tulasidhar.lms.service.BookService;
import jakarta.validation.Valid;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	public BookController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@GetMapping(value="/getallbooks",produces = "application/json")
	public List<Book> getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		return books;
	}
	
	@PostMapping(value="/addbook")
	public int addBook(@RequestBody @Valid Book book) throws DBConstrainsException{
		bookService.addNewBook(book);
		return 0;
	}
	
	@PostMapping("/updatebook")
	public int updatebook(@RequestBody @Valid Book book) {
		return 0;
	}
	
	
}
