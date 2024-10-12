package com.sun.furn.dao;

import com.sun.furn.entity.User;

import java.util.List;

public interface IUserDao {
    public void addUser(User user) throws Exception;
    public List<User> getAllUser()throws Exception;
    public List<User> getUserByName(String name)throws Exception;
}
