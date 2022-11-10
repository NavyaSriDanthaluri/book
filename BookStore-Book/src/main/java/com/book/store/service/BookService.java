package com.book.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.book.store.entity.Book;

@Service
public interface BookService {
	
	public Book insertBook(Book book) throws Exception;
	public Book getBookByISBNumber(int ISBNumber) throws Exception;
	public List<Book> getAllBooks() throws Exception;
	public List<Book> getBooksByCategory(String category) throws Exception;
	
}
