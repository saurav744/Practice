package com.saurav.myblogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.myblogapp.model.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, Long>{
	
	List<UserComment> findByPublication(long pubId);
	
	

}
