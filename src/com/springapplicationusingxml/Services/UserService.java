package com.springapplicationusingxml.Services;

import com.springapplicationusingxml.entities.User;

import java.util.List;

/**
 * Created by muhamamddanish on 10/7/16.
 */
public interface UserService {
    public void insertUser(User user);
    public void updateUser(User user);
    public User getUser(String name);
    public List<User> getUsers();
    public void deleteUser(int id);
}
