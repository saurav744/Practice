package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublicationRepositoryImpl implements PublicationRepository {

    private Map<Long, Publication> publications = new HashMap<>();
    private Map<Long, Publication> pending = new HashMap<>();
    private long next_id = 0;



    @Override
    public void addPublication(Publication publication) {

        publication.setId(next_id);
        publications.put(next_id,publication);
        next_id++;

    }

    @Override
    public void deletepublication(long id) {

        publications.remove(id);

    }

    @Override
    public void updatepublication(long id, Publication publication) {

    }

    @Override
    public List<Publication> getpublications(User author) {
        return null;
    }

    @Override
    public Publication getpublicationbyid(long id) {
        return publications.get(id);
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
