package com.lms.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.Models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByAuthor(String author);

	@Query("from Book where added_by_user_id=?1")
	List<Book> findByUserId(Integer userId);
}
