package com.book.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.entity.Book;
import com.book.store.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;
	

	@Override
	public List<Book> getAllBooks() throws Exception {

		List<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}


	@Override
	public Book insertBook(Book book) throws Exception {
		Book savedBook = bookRepository.save(book);
		if(savedBook != null)
		{
			return savedBook;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws Exception {
		
		return bookRepository.getBooksByCategory(category);
	}


	@Override
	public Book getBookByISBNumber(int ISBNumber) throws Exception {
	
		return bookRepository.getById(ISBNumber);
	}

}
