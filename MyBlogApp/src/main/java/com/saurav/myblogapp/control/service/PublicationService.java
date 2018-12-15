package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;
import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserComment;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PublicationService {

    public void addPublication(Publication publication);

    public void deletePublication(long id, User user);

    public void updatePublication(long id, String body, String title, User curr_user);

    //public List<Publication> getPublications(User author);

    public Publication getPublicationById(long id);

    public void changeState(long id, PublicationState state, User curr_user);

    public void approvePublication(long id, User curr_user);

    public Set<Map.Entry<Long, Publication>> getAllPublications();

    public boolean isAuthor(User user, long id);

    public void addComment(long id, UserComment comment);

    public void editComment(long id, int index, String body);

    public List<UserComment> getComments(long id);

    public void deleteComment (long id, int index);

}

