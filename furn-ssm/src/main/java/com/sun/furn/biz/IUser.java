package com.sun.furn.biz;

import com.sun.furn.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUser {
    public void addUser(User user)throws Exception;
    public List<User> getAllUser()throws Exception;
    public List<User> getUserByName(String name)throws Exception;
}
