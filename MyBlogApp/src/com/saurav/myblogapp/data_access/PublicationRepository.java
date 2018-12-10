package com.saurav.myblogapp.data_access;

import com.saurav.myblogapp.control.model.Publication;
import com.saurav.myblogapp.control.model.User;

import java.util.List;

public interface PublicationRepository {

    public void addPublication(Publication publication);

    public void deletepublication(long id);

    public void updatepublication(long id, Publication publication);

    public List<Publication> getpublications(User author);

    public Publication getpublicationbyid(long id);

    public void changetype(Publication publication);

    public void approve_publication (long id);

    public List<Publication> getallpublications();
}
