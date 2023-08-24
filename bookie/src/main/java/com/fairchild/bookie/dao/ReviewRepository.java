package com.fairchild.bookie.dao;

import com.fairchild.bookie.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByBookId(@RequestParam("book_id") long bookId, Pageable pageable);

    Review findByUserEmailAndBookId(String userEmail, Long bookId);

}
