package com.covoiturage.fb.login;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

public class UserDetails {

    public static UserProfile GetUserProfile(String accessToken) {

        UserProfile user_profile = new UserProfile();
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_3_0);

        User user = fbClient.fetchObject("me",User.class);
        user_profile.setName(user.getName());
        //System.out.println("Use name : "+user.getName());

        return user_profile;
    }


}
