package com.example.mfsum.util;

import com.example.mfsum.business.User;
public class UserUtils {
    private UserUtils() {
        throw new UnsupportedOperationException();
    }

    public static User loggedInUser;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void loginUser(User user) {
        UserUtils.loggedInUser = user;
    }

}
