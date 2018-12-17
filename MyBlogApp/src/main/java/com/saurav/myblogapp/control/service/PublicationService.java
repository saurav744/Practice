package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;
import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserComment;
import com.saurav.myblogapp.exceptions.PublicationNotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface PublicationService {

    public void addPublication(Publication publication);

    public void deletePublication(long id, User user);

    public void updatePublication(long id, String body, String title, User curr_user) throws PublicationNotFoundException;

    //public List<Publication> getPublications(User author);

    public Publication getPublicationById(long id);

    public void changeState(long id, PublicationState state, User curr_user);

    public void approvePublication(long id, User curr_user);

    public ArrayList<Publication> getAllPublications();

    public ArrayList<Publication> getPending();

    public boolean isAuthor(User user, long id);

    public void addComment(long id, UserComment comment);

    public void editComment(long id, int index, String body);

    public List<UserComment> getComments(long id);

    public void deleteComment (long id, int index);

    public List<Publication> searchContent(String key);

    public List<Publication> searchAuthor(String key);

}

