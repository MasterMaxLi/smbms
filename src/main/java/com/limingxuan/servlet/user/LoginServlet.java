package com.limingxuan.servlet.user;

import com.limingxuan.pojo.User;
import com.limingxuan.service.user.UserService;
import com.limingxuan.service.user.UserServiceImpl;
import com.limingxuan.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Creqated by Limingxuan on 2021/2/27
 */
public class LoginServlet extends HttpServlet {

    //Servlet:控制层，调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServle start...");
        //从前端获取用户名密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //调用业务层，和数据库中的userCode和userPassword对比
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        //如果用户不为空，则说明用户存在，可以登录
        if(user != null){
            //将用户的信息放入Session中
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转到主页
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            //用户为空，无法登录
            req.setAttribute("error", "用户名或密码错误！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
