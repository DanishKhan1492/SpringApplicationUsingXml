package com.springapplicationusingxml.ServicesImpl;

import com.springapplicationusingxml.Daos.UserDao;
import com.springapplicationusingxml.Services.UserService;
import com.springapplicationusingxml.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by muhamamddanish on 10/7/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
