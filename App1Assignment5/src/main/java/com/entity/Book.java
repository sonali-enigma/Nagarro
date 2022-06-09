package com.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {

	int bookCode;

	String bookName;

	String author;

	String addedOn;

	public Book() {
		super();
	}

	public Book(int bookCode, String bookName, String author, String addedOn) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.addedOn = addedOn;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author + ", addedOn=" + addedOn
				+ "]";
	}

}
