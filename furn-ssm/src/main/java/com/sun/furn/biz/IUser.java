package com.sun.furn.biz;

import com.sun.furn.entity.User;
import org.springframework.stereotype.Service;


public interface IUser {
    public void addUser(User user)throws Exception;
}
