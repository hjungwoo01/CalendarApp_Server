package com.hjungwoo01.calendarappserver.model.dao.user;

import com.hjungwoo01.calendarappserver.model.user.User;

import java.util.List;

public interface UserDAO {
    User save(User user);
    List<User> getAll();
    User getById(long id);
    List<User> getByUuid(String uuid);
    void delete(long id);
    void deleteByNameAndUuid(String name, String uuid);
}