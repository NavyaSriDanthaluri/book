package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.entity.Book;
import com.book.store.service.BookService;

@RestController
@RequestMapping("/bookstore")
public class BookRestController {
	
	@Autowired
	BookService bookService;
	
	public BookRestController() {
		System.out.println("\n\n\n=======>> Inside Contructor "+this);
	}

	@GetMapping("/welcome")
	public String welcome()
	{
		
		return "Welcome to Book Store";
		
	}
	
	@PostMapping("/addbook")
	public ResponseEntity<String> addBook(@RequestBody Book book)
	{
		try {
			Book savedBook = bookService.insertBook(book);
			String responseMsg = savedBook.getTitle()+"save with ISBNumber"+savedBook.getISBNumber();
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		}catch(Exception e) {
			String errorMsg = "Contact customer care Ph.no:- 1800-250-900 or mail to:- bookstore@gmail.com";
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		try {
			List<Book> allExtractedBooks = bookService.getAllBooks();
			return allExtractedBooks;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/isbnumber/{isbnumber}")
	public Book getBookByISBNumber(int ISBNumber) throws Exception
	{
		
		return bookService.getBookByISBNumber(ISBNumber);
		
	}
	
	@GetMapping("/category/{category}")
	public List<Book> getBookByCategory(String category) throws Exception
	{
		
		return bookService.getBooksByCategory(category);
		
	}
	
}








