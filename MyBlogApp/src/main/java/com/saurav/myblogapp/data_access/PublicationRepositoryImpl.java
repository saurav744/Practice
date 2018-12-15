package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;
import com.saurav.myblogapp.control.model.UserComment;

import java.util.HashMap;
import java.util.List;
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
    public void addToApproved(long id, Publication publication) {

        publications.put(id, publication);

    }

    @Override
    public void deletePublication(long id) {

        if(publications.containsKey(id))
        publications.remove(id);

        else if(pending.containsKey(id))
            pending.remove(id);

    }

    @Override
    public void removePending(long id) {

        pending.remove(id);

    }

    @Override
    public void updatePublication(long id, Publication publication) {

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
    public void addComment(long id, UserComment comment) {

        Publication pub = getpublicationbyid(id);
        pub.addComment(comment);

    }

    @Override
    public void deleteComment(long id, int index) {

        Publication pub = getpublicationbyid(id);
        pub.deleteComment(index);

    }

    @Override
    public void editComment(long id, int index, String body) {

        Publication publication = getpublicationbyid(id);

        publication.getComments().get(index).setBody(body);

    }

    @Override
    public List<UserComment> getComments(long id) {
        Publication pub = getpublicationbyid(id);
        return pub.getComments();
    }

    @Override
    public Set<Map.Entry<Long, Publication>> getAllPublications() {
        return publications.entrySet();
    }
}
