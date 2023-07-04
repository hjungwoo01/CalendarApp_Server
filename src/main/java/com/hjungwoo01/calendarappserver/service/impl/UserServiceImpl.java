package com.hjungwoo01.calendarappserver.service.impl;

import com.hjungwoo01.calendarappserver.exception.ResourceNotFoundException;
import com.hjungwoo01.calendarappserver.model.user.User;
import com.hjungwoo01.calendarappserver.model.dao.user.UserDAO;
import com.hjungwoo01.calendarappserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public User saveUser(User memo) {
        return userDAO.save(memo);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public User getUserById(long id) {
        User user = userDAO.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User", "Id", id);
        }
        return user;
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setFace(user.getFace());
        return userDAO.save(existingUser);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.delete(id);
    }
}
