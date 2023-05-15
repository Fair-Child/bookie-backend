package com.bookie.bookie.dao;

import com.bookie.bookie.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {



}
