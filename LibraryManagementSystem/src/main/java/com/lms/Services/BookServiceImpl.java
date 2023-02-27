package com.lms.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lms.Exceptions.BookNotFoundException;
import com.lms.Exceptions.UserNotFoundException;
import com.lms.Models.Book;
import com.lms.Models.User;
import com.lms.Playload.Request.BookRequest;
import com.lms.Repositories.BookRepository;
import com.lms.Repositories.UserRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	private UserRepository userRepository;
	private ModelMapper mapper;

	public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository, ModelMapper mapper) {
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public Book addNewBook(BookRequest bookRequest, Integer userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
		Book book = mapper.map(bookRequest, Book.class);
		book.setAddedBy(user);
		return bookRepository.save(book);

	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book not found with Id " + bookId));
		return book;
	}

	@Override
	public List<Book> getBookByauthor(String author) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepository.findByAuthor(author);
		return books;
	}

	@Override
	public List<Book> getBooksByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepository.findByUserId(userId);
		return books;
	}


}
