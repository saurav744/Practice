package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PublicationRepositoryImpl implements PublicationRepository {

    private Map<Long, Publication> publications = new HashMap<>();
    private Map<Long, Publication> pending = new HashMap<>();
    private long next_id = 1;



    @Override
    public void addPublication(Publication publication) {

        publication.setId(next_id);
        pending.put(next_id,publication);
        next_id++;

    }

    @Override
    public void addtoApproved(long id, Publication publication) {

        publications.put(id, publication);

    }

    @Override
    public void deletepublication(long id) {

        publications.remove(id);

    }

    @Override
    public void removePending(long id) {

        pending.remove(id);

    }

    @Override
    public void updatepublication(long id, Publication publication) {

        Publication pub_old= getpublicationbyid(id);
        pub_old.setBody(publication.getBody());
        pub_old.setTitle(publication.getTitle());

    }

    @Override
    public Publication getpublicationbyid(long id) {
        Publication ret= publications.get(id);
        if(ret == null)
            ret = pending.get(id);

        return ret;
    }

    @Override
    public void changeState(long id, PublicationState state) {
        Publication pub = getpublicationbyid(id);
        pub.setState(state);

    }

    @Override
    public Set<Map.Entry<Long, Publication>> getallpublications() {
        return publications.entrySet();
    }
}
