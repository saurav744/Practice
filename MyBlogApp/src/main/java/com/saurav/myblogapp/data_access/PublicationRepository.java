package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;
import com.saurav.myblogapp.control.model.UserComment;

import java.util.ArrayList;
import java.util.List;

public interface PublicationRepository {

    public void addPublication(Publication publication);

    public void deletePublication(long id);

    public void updatePublication(long id, Publication publication);

   // public List<Publication> getpublications(User author);

    public Publication getpublicationbyid(long id);

    public void changeState(long id, PublicationState state);

    public void removePending (long id);

    public ArrayList<Publication> getAllPublications();

    public ArrayList<Publication> getPending();

    public void addToApproved(long id, Publication publication);

    public void addComment(long id, UserComment comment);

    public void deleteComment(long id, int index);

    public void editComment (long id, int index, String body);

    public List<UserComment> getComments(long id);

    public List<Publication> searchContent(String key);

    public List<Publication> searchAuthor(String key);

}
