package com.demoregister.demo_register.cache;

import com.demoregister.demo_register.util.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManagement {

    private static Map<String, Session> SESSIONS = new ConcurrentHashMap<>();

    public static Session putSession(Integer userId){
        String token = StringUtil.randomString();
        Session session = new Session(token, userId, System.currentTimeMillis());
        SESSIONS.put(token, session);
        return session;
    }

    public static void removeSession(String token){
        SESSIONS.remove(token);
    }

    public static Integer getUserIdByToken(String token){
        return SESSIONS.get(token).getUserId();
    }

    public static boolean isExists(String token){
        return SESSIONS.containsKey(token);
    }

    public static void updateSession(Session session){
        SESSIONS.put(session.getToken(), session);
    }

    public static Session get(String token){
        return SESSIONS.get(token);
    }

    public static Map<String, Session> getSESSIONS(){
        return SESSIONS;
    }

}
