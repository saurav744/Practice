package com.saurav.myblogapp.data_access;

public class UserRepositoryFactory {

    public static UserRepositoryold getUserRepositoryInstance() {

        return new UserRepositoryImpl();

    }
}
