package com.limingxuan.service.user;

import com.limingxuan.dao.BaseDao;
import com.limingxuan.dao.user.UserDao;
import com.limingxuan.dao.user.UserDaoImpl;
import com.limingxuan.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Creqated by Limingxuan on 2021/2/27
 */
public class UserServiceImpl implements UserService{

    //业务层需引入dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String userPassword) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            user = userDao.getLoginUser(connection, userCode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }
}
