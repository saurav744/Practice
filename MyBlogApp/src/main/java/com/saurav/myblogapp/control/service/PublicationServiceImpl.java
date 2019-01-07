package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.*;
import com.saurav.myblogapp.data_access.PublicationRepositoryold;
import com.saurav.myblogapp.exceptions.PublicationNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class PublicationServiceImpl implements PublicationService {

    private PublicationRepositoryold publicationRepository;

    public PublicationServiceImpl(PublicationRepositoryold publicationRepository) {

        this.publicationRepository = publicationRepository;
    }

    @Override
    public void addPublication(Publication publication) {

        publicationRepository.addPublication(publication);

    }

    @Override
    public void deletePublication(long id, User curr_user) {

        if(curr_user.getType() == UserType.ADMIN || curr_user.getType() == UserType.MODERATOR || isAuthor(curr_user, id))
        publicationRepository.deletePublication(id);

    }

    @Override
    public boolean isAuthor(User user, long id) {
        Publication pub = getPublicationById(id);
        List<User> authors = pub.getAuthors();
        if(authors.contains(user))
        return true;
        return false;
    }

    @Override
    public void updatePublication(long id, String body, String title, User curr_user) throws PublicationNotFoundException {

        Publication pub = getPublicationById(id);
        if(isAuthor(curr_user,id))
        {
            Publication newpub = new Publication(title, body, curr_user, pub.getAddedDate(), pub.getType());
            publicationRepository.updatePublication(id, newpub);
        }

    }

    @Override
    public Publication getPublicationById(long id) {
        return publicationRepository.getpublicationbyid(id);
    }

    @Override
    public void changeState(long id, PublicationState state, User curr_user) {

        if(curr_user.getType() == UserType.ADMIN || curr_user.getType() == UserType.MODERATOR)
            publicationRepository.changeState(id, state);

    }

    @Override
    public ArrayList<Publication> getPending() {
        return publicationRepository.getPending();
    }

    @Override
    public void approvePublication(long id, User curr_user) {

        if(curr_user.getType() == UserType.ADMIN || curr_user.getType() == UserType.MODERATOR ) {

            Publication pub = getPublicationById(id);
            changeState(id, PublicationState.APPROVED, curr_user);
            publicationRepository.addToApproved(id, pub);
            publicationRepository.removePending(id);

        }
    }

    @Override
    public List<Publication> searchContent(String key) {
        return publicationRepository.searchContent(key);
    }

    @Override
    public List<Publication> searchAuthor(String key) {
        return publicationRepository.searchAuthor(key);
    }

    @Override
    public List<UserComment> getComments(long id) {

        return publicationRepository.getComments(id);

    }

    @Override
    public void editComment(long id, int index, String body) {

        publicationRepository.getComments(id).get(index).setBody(body);

    }

    @Override
    public ArrayList<Publication> getAllPublications() {
        return publicationRepository.getAllPublications();
    }

    @Override
    public void deleteComment(long id, int index) {

        publicationRepository.deleteComment(id, index);

    }

    @Override
    public void addComment(long id, UserComment comment) {
            //pub.addComment(comment);
            publicationRepository.addComment(id, comment);

    }
}