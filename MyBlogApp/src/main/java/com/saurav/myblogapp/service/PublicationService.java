package com.saurav.myblogapp.service;

import java.util.List;

import com.saurav.myblogapp.model.Publication;
import com.saurav.myblogapp.model.PublicationState;
import com.saurav.myblogapp.model.User;

public interface PublicationService {

    public void addPublication(Publication publication);

    public void deletePublication(long id);

    public void updatePublication(long id, Publication publication);

    //public List<Publication> getPublications(User author);

    public Publication getPublicationById(long id);

    public void changeState(long id, PublicationState state);

    public List<Publication> getAllPublications();

    public List<Publication> getPending();

    public boolean isAuthor(User user, long id);

}

