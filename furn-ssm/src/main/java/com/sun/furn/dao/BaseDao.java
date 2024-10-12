package com.sun.furn.dao;

import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

public class BaseDao extends JdbcDaoSupport{
    //mybatis
    private static SqlSessionFactory sqlSessionFactory;

    public SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
    static {
        try{
            String resource="Mybatis.xml";
            InputStream inputStream= Resources.getResourceAsStream(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Autowired
    public void setDataSource(org.springframework.jdbc.datasource.DriverManagerDataSource dataSource) {
        super.setDataSource(dataSource);
    }

    /**
     * 从Spring上下文中取得Connection，spring整合jdbc
     * @return
     */
    protected Connection openConnection() {
        return this.getConnection();
    }

}
