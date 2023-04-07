package com.saurabh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.entity.Book;
import com.saurabh.service.BookServie;

@RestController
@RequestMapping(value = "/book")
public class StudentController {
	@Autowired
	private BookServie service;

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		Book bookResponse = service.SaveBook(book);
		return bookResponse;
	}

	@RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBookDetails(@PathVariable int bookId) {
		Book bookResponse = service.findById(bookId);
		return bookResponse;
	}
}
