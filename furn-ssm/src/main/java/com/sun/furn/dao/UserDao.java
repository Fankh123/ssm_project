package com.sun.furn.dao;

import com.sun.furn.entity.User;
import com.sun.furn.mapper.IUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository("userDao")
public class UserDao extends BaseDao implements IUserDao{
    @Autowired
    //spring整合mybatis，使得持久层依赖mapper
    private IUserMapper mapper;
    public void addUser(User user) throws Exception {
        String sql = "insert into tuser values(?,?,?,?)";
        Connection conn = this.openConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUname());
        ps.setString(2, user.getSno());
        ps.setString(3, user.getPwd());
        ps.setInt(4, user.getRole());
        ps.executeUpdate();
        ps.close();
        //throw new RuntimeException("�쳣����....");
    }
    @Override
    public List<User> getAllUser() throws Exception{
        /*SqlSession session=this.getSession();
        IUserMapper mapper=session.getMapper(IUserMapper.class);*/
        return mapper.getAllUser();
    }

    @Override
    public List<User> getUserByName(String name) throws Exception {
        //未整合spring的mybatis的用法，打开一个session，然后获取一个映射接口
        /*SqlSession session=this.getSession();
        IUserMapper mapper=session.getMapper(IUserMapper.class);*/
        //整合了spring的mybatis用法，直接在dao中依赖一个映射接口由spring注入，直接调用mapper方法
        return mapper.getUserByName(name);
    }


}
