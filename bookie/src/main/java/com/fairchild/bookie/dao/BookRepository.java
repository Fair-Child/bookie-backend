package com.fairchild.bookie.dao;

import com.fairchild.bookie.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
