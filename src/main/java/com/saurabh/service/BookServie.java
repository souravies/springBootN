package com.saurabh.service;

import org.springframework.stereotype.Component;

import com.saurabh.entity.Book;

@Component
public interface BookServie {

	public Book SaveBook(Book book);

	public Book findById(Integer bookId);
}
