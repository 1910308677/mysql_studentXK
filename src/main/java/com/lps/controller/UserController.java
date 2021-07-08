package com.lps.controller;

import com.lps.modle.User;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserController extends BaseController {


    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<User> userList_db = userService.queryAllUser();
        //返回数据
        request.setAttribute("userList_db", userList_db);
        //2.跳转页面；
        return "view/system/user/userList.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String adress = request.getParameter("adress");
        String tel = request.getParameter("tel");
        String QQ = request.getParameter("QQ");
        String wechat = request.getParameter("wechat");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装
        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        user.setAdress(adress);
        user.setTel(tel);
        user.setQQ(QQ);
        user.setWechat(wechat);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        //3.调用业务。
        int n = userService.addUserByUser(user);

        //2.跳转页面；
        //准备数据
        List<User> userList_db = userService.queryAllUser();
        request.setAttribute("userList_db", userList_db);
        return "view/system/user/addUser.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String userIdSTR = request.getParameter("userIdSTR");
        //字符类型转数组类型
        int userId = Integer.parseInt(userIdSTR);

        //3.调用业务。
        int n = userService.deleteUserByUserId(userId);


        //2.跳转页面；
        //准备数据
        List<User> userList_db = userService.queryAllUser();
        request.setAttribute("userList_db", userList_db);
        return "view/system/user/addUser.jsp";
    }

    public String updateUI(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String userIdSTR = request.getParameter("userIdSTR");
        //字符类型转数组类型
        int userId = Integer.parseInt(userIdSTR);
        System.err.println(userId);
        //3.调用业务。
        User user_db = userService.queryUserByUserId(userId);
        System.out.println(user_db);
        //返回修改数据
        request.setAttribute("user_db", user_db);

        //2.跳转页面；

        return "view/system/user/updateUser.jsp";
    }


    public String update(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String userIdSTR = request.getParameter("userIdSTR");
        //字符类型转数组类型
        int userId = Integer.parseInt(userIdSTR);

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String adress = request.getParameter("adress");
        String tel = request.getParameter("tel");
        String QQ = request.getParameter("QQ");
        String wechat = request.getParameter("wechat");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        user.setAdress(adress);
        user.setTel(tel);
        user.setQQ(QQ);
        user.setWechat(wechat);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        System.err.println(user);

        //3.调用业务。
        int n = userService.updateUserByUser(user);

        //2.跳转页面；
        //准备数据
        List<User> userList_db = userService.queryAllUser();
        request.setAttribute("userList_db", userList_db);
        return "view/system/user/addUser.jsp";
    }
}
