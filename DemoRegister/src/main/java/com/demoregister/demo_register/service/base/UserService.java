package com.demoregister.demo_register.service.base;

import com.demoregister.demo_register.model.User;

import java.util.List;

public interface UserService extends Service<User> {

    User getUserByNameAndPhone(String name, String phone);

    List<User> getUser(String name, int page);

    List<User> getUserVer2(String name, int page);

}
