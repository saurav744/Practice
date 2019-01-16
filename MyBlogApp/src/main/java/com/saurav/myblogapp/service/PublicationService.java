package com.saurav.myblogapp.service;

import java.util.List;

import com.saurav.myblogapp.exceptions.PublicationNotFoundException;
import com.saurav.myblogapp.model.Publication;
import com.saurav.myblogapp.model.PublicationState;
import com.saurav.myblogapp.model.User;

public interface PublicationService {

    public void addPublication(Publication publication);

    public void deletePublication(long id) throws PublicationNotFoundException;

    public void updatePublication(long id, Publication publication) throws PublicationNotFoundException;

    public Publication getPublicationById(long id) throws PublicationNotFoundException;

    public void changeState(long id, PublicationState state) throws PublicationNotFoundException;

    public List<Publication> getAllPublications();

    public List<Publication> getPending();
    
    public boolean isPresent(long id);

    public boolean isAuthor(User user, long id) throws PublicationNotFoundException;

}

