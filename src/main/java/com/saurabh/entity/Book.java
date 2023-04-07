package com.saurabh.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;

	@Column(name = "book_name")
	private String bookname;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("book")
	private List<Story> storyList = new ArrayList<>();

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public List<Story> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<Story> storyList) {
		this.storyList = storyList;
	}

}
