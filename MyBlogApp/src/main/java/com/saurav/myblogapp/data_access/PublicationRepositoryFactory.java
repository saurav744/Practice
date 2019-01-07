package com.saurav.myblogapp.data_access;

public class PublicationRepositoryFactory {

    public static PublicationRepositoryold getPublicationRepositoryInstance() {

        return new PublicationRepositoryImpl();

    }
}
