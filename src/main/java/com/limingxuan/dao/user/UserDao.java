package com.limingxuan.dao.user;

import com.limingxuan.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Creqated by Limingxuan on 2021/2/27
 */
public interface UserDao {

    //要登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
}
