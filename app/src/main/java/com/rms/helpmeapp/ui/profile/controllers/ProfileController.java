package com.rms.helpmeapp.ui.profile.controllers;

import com.rms.helpmeapp.ui.profile.ProfileView;
import com.rms.helpmeapp.util.UserSingleton;

public class ProfileController {

    private ProfileView profileView;

    public ProfileController(ProfileView profileView) {
        this.profileView = profileView;
    }

    public void onViewCreated() {
        UserSingleton user = UserSingleton.getInstance();

        profileView.showUserData(user.user);
    }
}
