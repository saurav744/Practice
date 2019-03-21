package com.saurav.myblogapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.myblogapp.model.UserComment;
import com.saurav.myblogapp.repository.UserCommentRepository;


@Service("userCommentService")
@Transactional
public class UserCommentServiceImpl implements UserCommentService {
	
	@Autowired
    private UserCommentRepository userCommentRepository;

	@Override
	public void addComment(UserComment comment) {
		userCommentRepository.save(comment);
		
	}

	@Override
	public void editComment(long id, String body) {
		
		UserComment comment = userCommentRepository.getOne(id);
		comment.setBody(body);
		userCommentRepository.save(comment);
		
	}

	@Override
	public List<UserComment> getComments(long pubId) {
		
		return userCommentRepository.findByPublication(pubId);

	}

	@Override
	public void deleteComment(long id) {
		
		userCommentRepository.deleteById(id);
	}

}
