package com.spgcrud.druc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spgcrud.druc.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByLeadId(long leadId);//


}
