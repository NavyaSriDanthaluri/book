package com.book.store.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.book.store.entity.Book;

@Repository
public interface IBookCustomRepository {
	
	public List<Book> getBooksByCategory(String category) throws Exception;

}
