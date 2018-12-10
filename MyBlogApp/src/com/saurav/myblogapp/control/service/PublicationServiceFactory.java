package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.data_access.PublicationRepositoryFactory;

public class PublicationServiceFactory {

    public static PublicationService getPublicationServiceInstance() {

        return new PublicationServiceImpl(PublicationRepositoryFactory.getPublicationRepositoryInstance());
    }
}
