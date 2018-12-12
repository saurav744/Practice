package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.*;
import com.saurav.myblogapp.data_access.PublicationRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository) {

        this.publicationRepository = publicationRepository;
    }

    @Override
    public void addPublication(Publication publication) {

        publicationRepository.addPublication(publication);

    }

    @Override
    public void deletepublication(long id, User curr_user) {

        if(curr_user.getType() == UserType.ADMIN || isAuthor(curr_user, id))
        publicationRepository.deletepublication(id);

    }

    @Override
    public boolean isAuthor(User user, long id) {
        Publication pub = getpublicationbyid(id);
        List<User> authors = pub.getAuthors();
        if(authors.contains(user))
        return true;
        return false;
    }

    @Override
    public void updatepublication(long id, String body, String title, User curr_user) {

        Publication pub = getpublicationbyid(id);
        if(isAuthor(curr_user,id))
        {
            Publication newpub = new Publication(title, body, curr_user, pub.getAdded_date());
            publicationRepository.updatepublication(id, newpub);
        }

    }

    @Override
    public Publication getpublicationbyid(long id) {
        return publicationRepository.getpublicationbyid(id);
    }

    @Override
    public void changeState(long id, PublicationState state, User curr_user) {

        if(curr_user.getType() == UserType.ADMIN)
            publicationRepository.changeState(id, state);

    }

    @Override
    public void approve_publication(long id, User curr_user) {

        if(curr_user.getType() == UserType.ADMIN) {

            Publication pub = getpublicationbyid(id);
            changeState(id, PublicationState.APPROVED, curr_user);
            publicationRepository.addtoApproved(id, pub);
            publicationRepository.removePending(id);

        }
    }

    @Override
    public Set<Map.Entry<Long, Publication>> getallpublications() {
        return null;
    }

    @Override
    public void addComment(long id, Comment comment, User curr_user) {

        if(isAuthor(curr_user,id)) {
            Publication pub = getpublicationbyid(id);
            pub.addComment(comment);
        }

    }
}