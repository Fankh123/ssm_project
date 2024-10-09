package com.sun.furn.dao;

import com.sun.furn.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
@Repository("userDao")
public class UserDao extends BaseDao implements IUserDao{

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
}
