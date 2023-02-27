package com.lms.Services;

import java.util.List;

import com.lms.Exceptions.BookNotFoundException;
import com.lms.Exceptions.UserNotFoundException;
import com.lms.Models.Book;
import com.lms.Playload.Request.BookRequest;

public interface BookService {

	public Book addNewBook(BookRequest bookRequest, Integer userId) throws UserNotFoundException;

	public List<Book> getAllBooks();

	public Book getBookById(Integer bookId) throws BookNotFoundException;

	public List<Book> getBookByauthor(String author);

	public List<Book> getBooksByUserId(Integer userId);
}
