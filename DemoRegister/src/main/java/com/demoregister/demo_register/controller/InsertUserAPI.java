package com.demoregister.demo_register.controller;

import com.demoregister.demo_register.constant.ResponseCode;
import com.demoregister.demo_register.exception.ApplicationException;
import com.demoregister.demo_register.model.User;
import com.demoregister.demo_register.request.InsertUserRequest;
import com.demoregister.demo_register.response.InsertUserResponse;
import com.demoregister.demo_register.response.ResponseEntity;
import com.demoregister.demo_register.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertUserAPI extends AbstractController<InsertUserRequest> {

    @Autowired
    private UserService userService;

    @PostMapping("/user/insert")
    public String insertUser(@RequestBody InsertUserRequest request) {
        return execute(request);
    }

    @Override
    protected void validate(InsertUserRequest abstractRequest) {
        if (abstractRequest.getName().isEmpty()){
            throw new ApplicationException(ResponseCode.WRONG_DATA_FORMAT);
        }
    }

    @Override
    protected String handler(InsertUserRequest abstractRequest) {
        User userData = new User(abstractRequest.getName(), abstractRequest.getPhone());
        User userResult = userService.insertUser(userData);
        return new ResponseEntity(new InsertUserResponse(userResult)).toString();
    }


}
