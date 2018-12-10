package com.saurav.myblogapp.control.service;

import com.saurav.myblogapp.data_access.UserRepositoryFactory;

public class UserServiceFactory {

    public static UserService getUserServiceInstance() {

        return new UserServiceImpl(UserRepositoryFactory.getUserRepositoryInstance());
    }
}

