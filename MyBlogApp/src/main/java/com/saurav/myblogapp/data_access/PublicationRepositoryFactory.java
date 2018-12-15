package com.saurav.myblogapp.data_access;

public class PublicationRepositoryFactory {

    public static PublicationRepository getPublicationRepositoryInstance() {

        return new PublicationRepositoryImpl();

    }
}
