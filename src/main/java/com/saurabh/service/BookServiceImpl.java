package com.saurabh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.entity.Book;
import com.saurabh.entity.Story;
import com.saurabh.repository.BookRepository;
import com.saurabh.repository.StoryRepository;

@Service
public class BookServiceImpl implements BookServie {

	@Autowired
	private BookRepository bookrepo;
	@Autowired
	private StoryRepository storyrepo;

	@Override
	public Book SaveBook(Book book) {
		List<Story> storyList = new ArrayList<>();

		// create one story
		Story story1 = new Story();
		story1.setStoryName("push ki raat");

		// create secons story
		Story story2 = new Story();
		story2.setStoryName("Idagh");

		// create thrid story
		Story story3 = new Story();
		story3.setStoryName("story of two taxes");

		// add all story into storylist .Till here we have prepared date for
		// one to many
		storyList.add(story1);
		storyList.add(story2);
		storyList.add(story3);

		// prpare many to one
		story1.setBook(book);
		story2.setBook(book);
		story3.setBook(book);

		book.setStoryList(storyList);
		book = bookrepo.save(book);

		return book;
	}

	@Override
	public Book findById(Integer bookId) {
		Optional<Book> book = bookrepo.findById(bookId);
		return book.get();
	}

}
