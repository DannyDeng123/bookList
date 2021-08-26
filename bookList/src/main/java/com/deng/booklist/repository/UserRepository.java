package com.deng.booklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.booklist.entity.Book;
import com.deng.booklist.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsernameAndPassword(String username, String password);
}
