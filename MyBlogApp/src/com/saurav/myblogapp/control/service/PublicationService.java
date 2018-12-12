package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.Comment;
import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;
import com.saurav.myblogapp.control.model.User;

import java.util.Map;
import java.util.Set;

public interface PublicationService {

    public void addPublication(Publication publication);

    public void deletepublication( long id, User user);

    public void updatepublication(long id, String body, String title, User curr_user);

    //public List<Publication> getpublications(User author);

    public Publication getpublicationbyid(long id);

    public void changeState(long id, PublicationState state, User curr_user);

    public void approve_publication (long id, User curr_user);

    public Set<Map.Entry<Long, Publication>> getallpublications();

    public boolean isAuthor(User user, long id);

    public void addComment(long id, Comment comment,User user);

}

