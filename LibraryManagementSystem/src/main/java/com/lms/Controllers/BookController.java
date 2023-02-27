package com.lms.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lms.Exceptions.BookNotFoundException;
import com.lms.Exceptions.UserNotFoundException;
import com.lms.Models.Book;
import com.lms.Playload.Request.BookRequest;
import com.lms.Services.BookService;

@RestController
@RequestMapping("/lms/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/create/{userId}")
	public ResponseEntity<Book> createNewBook(@PathVariable Integer userId, @RequestBody BookRequest bookRequest)
			throws UserNotFoundException {
		Book book = bookService.addNewBook(bookRequest, userId);
		return new ResponseEntity<Book>(book,HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) throws BookNotFoundException{
		Book book = bookService.getBookById(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam String author) {
		List<Book> books = bookService.getBookByauthor(author);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/byuserid")
	public ResponseEntity<List<Book>> getBookByUser(@RequestParam Integer userId){
		List<Book> books = bookService.getBooksByUserId(userId);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
}
