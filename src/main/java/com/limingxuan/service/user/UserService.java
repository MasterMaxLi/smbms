package com.limingxuan.service.user;

import com.limingxuan.pojo.User;

/**
 * Creqated by Limingxuan on 2021/2/27
 */
public interface UserService {
    //用户登录
    public User login(String userCode, String userPassword);
}
