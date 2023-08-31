package com.fairchild.bookie.dao;

import com.fairchild.bookie.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
