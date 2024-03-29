package com.springboot.architectural.repository;

import com.springboot.architectural.entity.Comment;
import com.springboot.architectural.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
