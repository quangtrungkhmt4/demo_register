package com.demoregister.demo_register.service.base;

import com.demoregister.demo_register.model.AbstractModel;
import com.demoregister.demo_register.model.User;

import java.util.List;

public interface Service<T extends AbstractModel> {
    T insertUser(T t);
    T updateUser(T t);
    void removeUser(Integer id);
    List<T> getAll();
}
