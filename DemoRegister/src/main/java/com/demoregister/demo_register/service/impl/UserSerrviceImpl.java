package com.demoregister.demo_register.service.impl;

import com.demoregister.demo_register.constant.ResponseCode;
import com.demoregister.demo_register.exception.ApplicationException;
import com.demoregister.demo_register.model.User;
import com.demoregister.demo_register.repository.UserRepository;
import com.demoregister.demo_register.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerrviceImpl implements UserService {

    private static final int LIMIT = 10;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByNameAndPhone(String name, String phone) {
        User user = userRepository.findUserByNameAndPhone(name, phone);
        if (user == null){
            throw new ApplicationException(ResponseCode.USER_NOT_FOUND);
        }
        return user;
    }

    @Override
    public List<User> getUser(String name, int page) {
        int offset = (page - 1) * LIMIT;
        return userRepository.findAllByNameLikeNativeQuery(name, LIMIT, offset);
    }

    @Override
    public List<User> getUserVer2(String name, int page) {
        Pageable pageable = PageRequest.of(page - 1, LIMIT, Sort.by("name").descending());
        return userRepository.findAllByNameContaining(name, pageable);
    }
}
