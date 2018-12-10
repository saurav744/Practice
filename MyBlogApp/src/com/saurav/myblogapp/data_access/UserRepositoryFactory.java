package com.saurav.myblogapp.data_access;

public class UserRepositoryFactory {

    public static UserRepository getUserRepositoryInstance() {

        return new UserRepositoryImpl();

    }
}
