package com.hjungwoo01.calendarappserver.service;

import com.hjungwoo01.calendarappserver.model.user.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
    List<User> getUsersByUuid(String uuid);
    void deleteUserByName(String name);
}
