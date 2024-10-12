package com.sun.furn.biz;

import com.sun.furn.dao.IUserDao;
import com.sun.furn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBiz implements IUser{
    @Autowired
    private IUserDao userDao;
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void addUser(User user) throws Exception {
        // 校验参数
        if (user == null) {
            throw new Exception("用户信息不能为空");
        }
        if (user.getSno() == null || user.getSno().isEmpty()) {
            throw new Exception("用户编号不能为空");
        }
        if (user.getPwd() == null || user.getPwd().isEmpty()) {
            throw new Exception("用户密码不能为空");
        }

        try {
            // 调用 DAO 层添加用户
            if (userDao != null) {
                userDao.addUser(user);
            }
        } finally {
            // 数据库资源的清理可以由 Spring 的事务管理来自动处理
        }
    }
    @Transactional
    public List<User> getAllUser()throws Exception{
        return userDao.getAllUser();
    }
    @Transactional
    public List<User> getUserByName(String name)throws Exception{
        return userDao.getUserByName(name);
    }
}
