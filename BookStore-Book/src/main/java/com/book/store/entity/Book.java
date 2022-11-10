package com.book.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ISBNumber;
	private String title;
	private String authorName;
	private String category;
	private int price;
	private float avgerageRating;
	
	
	public Book(String title, String authorName, String category, int price, float avgerageRating) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.category = category;
		this.price = price;
		this.avgerageRating = avgerageRating;
	}
	
}
