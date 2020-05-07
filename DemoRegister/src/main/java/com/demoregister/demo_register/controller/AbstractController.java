package com.demoregister.demo_register.controller;

import com.demoregister.demo_register.cache.Session;
import com.demoregister.demo_register.cache.SessionManagement;
import com.demoregister.demo_register.constant.ResponseCode;
import com.demoregister.demo_register.exception.ApplicationException;
import com.demoregister.demo_register.request.AbstractRequest;
import com.demoregister.demo_register.response.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController<T extends AbstractRequest> {

    protected String execute(T t) {
        try {
            validate(t);
            return handler(t);
        } catch (ApplicationException e) {
            return new ResponseEntity(e.getCode()).toString();
        } catch (Exception e) {
            return new ResponseEntity(ResponseCode.ERROR).toString();
        }
    }

    protected abstract void validate(T t);

    protected abstract String handler(T t);

    protected Integer getUserIdByToken(String token){
        Integer userId = SessionManagement.getUserIdByToken(token);
        if (userId == null){
            throw new ApplicationException(ResponseCode.TOKEN_EXPIRED);
        }
        updateLastRequestTime(SessionManagement.get(token));
        return userId;
    }

    private void updateLastRequestTime(Session session){
        session.setLastRequestTime(System.currentTimeMillis());
        SessionManagement.updateSession(session);
    }

}
