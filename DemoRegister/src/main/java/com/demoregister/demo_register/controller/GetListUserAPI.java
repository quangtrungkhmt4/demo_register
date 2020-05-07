package com.demoregister.demo_register.controller;

import com.demoregister.demo_register.model.User;
import com.demoregister.demo_register.request.GetListUserRequest;
import com.demoregister.demo_register.response.GetListUsersResponse;
import com.demoregister.demo_register.response.ResponseEntity;
import com.demoregister.demo_register.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListUserAPI extends AbstractController<GetListUserRequest>{

    @Autowired
    private UserService userService;

    @PostMapping("/user/list")
    public String getListUser(@RequestBody GetListUserRequest request){
        return execute(request);
    }

    @Override
    protected void validate(GetListUserRequest getListUserRequest) {
        getUserIdByToken(getListUserRequest.getToken());
    }

    @Override
    protected String handler(GetListUserRequest getListUserRequest) {
        List<User> users = userService.getUserVer2(getListUserRequest.getName(), getListUserRequest.getPage());
        GetListUsersResponse response = new GetListUsersResponse(users);
        return new ResponseEntity(response).toString();
    }
}
