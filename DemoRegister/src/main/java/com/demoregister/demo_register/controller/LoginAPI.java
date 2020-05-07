package com.demoregister.demo_register.controller;

import com.demoregister.demo_register.cache.Session;
import com.demoregister.demo_register.cache.SessionManagement;
import com.demoregister.demo_register.constant.ResponseCode;
import com.demoregister.demo_register.exception.ApplicationException;
import com.demoregister.demo_register.model.User;
import com.demoregister.demo_register.request.InsertUserRequest;
import com.demoregister.demo_register.response.LoginResponse;
import com.demoregister.demo_register.response.ResponseEntity;
import com.demoregister.demo_register.service.base.UserService;
import com.demoregister.demo_register.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAPI extends AbstractController<InsertUserRequest>{

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody InsertUserRequest request){
        return execute(request);
    }


    @Override
    protected void validate(InsertUserRequest request) {
        if (!StringUtil.validateString(request.getName(), request.getPhone())){
            throw new ApplicationException(ResponseCode.WRONG_DATA_FORMAT);
        }
    }

    @Override
    protected String handler(InsertUserRequest request) {
        User user = userService.getUserByNameAndPhone(request.getName(), request.getPhone());
        if (user == null){
            throw new ApplicationException(ResponseCode.USER_NOT_FOUND);
        }
        Session session = SessionManagement.putSession(user.getId());
        LoginResponse response = LoginResponse.builder()
                .token(session.getToken())
                .phone(user.getPhone())
                .userName(user.getName()).build();
        return new ResponseEntity(response).toString();
    }
}
