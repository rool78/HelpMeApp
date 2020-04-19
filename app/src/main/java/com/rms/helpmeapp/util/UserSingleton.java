package com.rms.helpmeapp.util;

import com.rms.helpmeapp.model.User;

public class UserSingleton {

    private static UserSingleton userSingleton = null;

    public User user;

    private UserSingleton(){
        this.user = new User();
    }

    public static UserSingleton getInstance(){
        if (userSingleton == null)
            userSingleton = new UserSingleton();

        return userSingleton;
    }
}

