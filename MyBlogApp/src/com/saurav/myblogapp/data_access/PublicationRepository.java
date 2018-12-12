package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.PublicationState;

import java.util.Map;
import java.util.Set;

public interface PublicationRepository {

    public void addPublication(Publication publication);

    public void deletepublication(long id);

    public void updatepublication(long id, Publication publication);

   // public List<Publication> getpublications(User author);

    public Publication getpublicationbyid(long id);

    public void changeState(long id, PublicationState state);

    public void removePending (long id);

    public Set<Map.Entry<Long, Publication>> getallpublications();

    public void addtoApproved (long id, Publication publication);
}
