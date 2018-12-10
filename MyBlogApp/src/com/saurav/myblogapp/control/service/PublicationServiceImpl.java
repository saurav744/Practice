package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.data_access.PublicationRepository;

import java.util.List;

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
    public void deletepublication( long id) {
        publicationRepository.deletepublication(id);

    }

    @Override
    public void updatepublication(Publication publication) {

    }

    @Override
    public List<Publication> getpublications(User author) {
        return null;
    }

    @Override
    public Publication getpublicationbyid(long id) {
        return publicationRepository.getpublicationbyid(id);
    }

    @Override
    public void changetype(Publication publication) {

    }

    @Override
    public void approve_publication(long id) {

    }

    @Override
    public List<Publication> getallpublications() {
        return null;
    }
}
