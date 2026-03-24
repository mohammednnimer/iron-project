package org.gs.auth.session;


import org.gs.entity.UsersTbl;

public class UserSession {
    public static UsersTbl user;

    public static void setUser(UsersTbl user) {
        UserSession.user = user;
    }

    public static UsersTbl getUser() {
        return user;
    }

    public static void clear() {
        user = null;
    }
}