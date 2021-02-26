package com.limingxuan.test;

import com.limingxuan.pojo.User;
import com.limingxuan.service.user.UserServiceImpl;
import org.junit.Test;

/**
 * Creqated by Limingxuan on 2021/2/27
 */
public class MyTest {
    @Test
    public void serviceImplTest(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("test", "111");
        System.out.println(admin.getUserPassword());
    }
}
