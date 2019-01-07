package com.saurav.myblogapp.data_access;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurav.myblogapp.control.model.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, Long>{

}
