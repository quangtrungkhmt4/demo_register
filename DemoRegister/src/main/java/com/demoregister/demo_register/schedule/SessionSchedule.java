package com.demoregister.demo_register.schedule;

import com.demoregister.demo_register.cache.Session;
import com.demoregister.demo_register.cache.SessionManagement;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class SessionSchedule {

    private static final int ONE_MINUTE = 1000 * 60;
    private static final int THIRTY_MINUTES = 1000 * 60 * 30;

    @Scheduled(fixedDelay = ONE_MINUTE)
    public void checkSession(){
        Map<String, Session> sessionMap = SessionManagement.getSESSIONS();
        System.out.println(sessionMap);

        Set<String> tokenRemove = new HashSet<>();

        sessionMap.forEach((token, session) -> {
            Long lastRequest = session.getLastRequestTime();
            if (System.currentTimeMillis() - lastRequest > THIRTY_MINUTES){
                tokenRemove.add(token);
            }
        });
        sessionMap.keySet().removeAll(tokenRemove);

    }
}
