package com.sun.furn.dao;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDao extends JdbcDaoSupport{

    @Autowired
    public void setDataSource(org.springframework.jdbc.datasource.DriverManagerDataSource dataSource) {
        super.setDataSource(dataSource);
    }

    /**
     * 从Spring上下文中取得Connection
     * @return
     */
    protected Connection openConnection() {
        return this.getConnection();
    }

}
