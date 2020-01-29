package com.covoiturage.fb.login;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.Group;
import com.restfb.types.Post;
import com.restfb.types.User;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {

    public static UserProfile GetUserProfile(String accessToken) {

        UserProfile user_profile = new UserProfile();
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_3_0);

        User user = fbClient.fetchObject("me",User.class);
        user_profile.setName(user.getName());
        //System.out.println("Use name : "+user.getName());

        return user_profile;
    }
    public static List<String> GetGroupPosts(String accessToken) {
        List<String> list = new ArrayList<>();
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_3_0);
        Connection<Group> groupsFeed = fbClient.fetchConnection("me/groups", Group.class);

        for (List<Group> page : groupsFeed) {
            for (Group aGroup : page) {
                if (aGroup.getName().equals("Wessalni_Dev")) {
                    Connection<Post> postFeed = fbClient.fetchConnection(aGroup.getId() + "/feed", Post.class);
                    for (List<Post> postPage : postFeed) {
                        for (Post post : postPage) {
                            list.add(post.getMessage());
                        }
                    }
                    break;
                }
            }
        }
        return list;

    }


}
