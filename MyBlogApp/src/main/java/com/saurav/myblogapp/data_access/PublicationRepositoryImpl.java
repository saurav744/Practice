package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;
import com.saurav.myblogapp.control.model.User;
import com.saurav.myblogapp.control.model.UserComment;

import java.util.*;

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
    public ArrayList<Publication> getPending() {

        ArrayList<Publication> pubList = new ArrayList<Publication>(pending.values());
        return pubList;

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
    public List<Publication> searchContent(String key) {
        List<Publication> pubList = new ArrayList<>();

        Iterator pbIterator = publications.entrySet().iterator();

        while (pbIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)pbIterator.next();
            Publication pub = (Publication)mapElement.getValue();
            if(pub.getBody().contains(key) || pub.getTitle().contains(key))
                pubList.add(pub);
        }
        return pubList;
    }

    @Override
    public List<Publication> searchAuthor(String key) {
        List<Publication> pubList = new ArrayList<>();

        Iterator pbIterator = publications.entrySet().iterator();

        while (pbIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)pbIterator.next();

            Publication pub = (Publication)mapElement.getValue();
            for(User usr : pub.getAuthors()) {
                if(usr.getFirstName().contains(key) || usr.getLastName().contains(key))
                    pubList.add(pub);
            }

        }
        return null;
    }

    @Override
    public ArrayList<Publication> getAllPublications() {
        ArrayList<Publication> pubList = new ArrayList<Publication>(publications.values());
        return pubList;
    }
}
