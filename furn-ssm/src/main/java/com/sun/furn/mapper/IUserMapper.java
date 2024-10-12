package com.sun.furn.mapper;

import com.sun.furn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;


public interface IUserMapper {
    public List<User> getAllUser()throws Exception;
    public List<User> getUserByName(String name)throws Exception;
}
