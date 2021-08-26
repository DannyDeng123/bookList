package com.deng.booklist.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.deng.booklist.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	
	Page<Book> findAll(Pageable pageable);
	
	List<Book> findByAuthor(String author);
	
	@Query(value = "SELECT * FROM bookList b WHERE LENGTH(b.name) > ?1"
			, nativeQuery = true)
	List<Book> findByJPQL(int len);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.status = ?1 where id = ?2")
	int updateStatusByJPQL(int status, long id);
	
}
