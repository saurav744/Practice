package com.saurav.myblogapp.service;

import java.util.List;

import com.saurav.myblogapp.model.UserComment;

public interface UserCommentService {

	public void addComment(UserComment comment);

	public void editComment(long id, String body);

	public List<UserComment> getComments(long pubId);

	public void deleteComment(long id);

}
