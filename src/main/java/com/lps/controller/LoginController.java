package com.lps.controller;

import com.lps.modle.Permission;
import com.lps.modle.User;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public class LoginController extends BaseController {


    public String login(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        //3.调用业务。
        //封装
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user);

        //调用业务
        User user_db = userService.queryUserByUser(user);
        System.err.println(user_db);

        //--》业务判断
        if (user_db != null) {
//        if (username.equals("admin") && password.equals("111")) {
            if (username.equals(user_db.getUsername()) && password.equals(user_db.getPassword())) {
                //登录用户信息保持到Session
                HttpSession session = request.getSession();
                session.setAttribute("USER", user_db);

                //友情提示
                request.setAttribute("message", "成功登陆！");
                //2.跳转页面；
                return "view/frame/main.jsp";
            } else {
                //友情提示
                request.setAttribute("message", "用户名或密码错误，请重新输入！");
                //2.跳转页面；
                return "login.jsp";
            }
        } else {
            //友情提示
            request.setAttribute("message", "请输入用户名和密码！");
            //2.跳转页面；
            return "login.jsp";
        }

    }

    public String left(HttpServletRequest request, HttpServletResponse response) {
        //######################## 登录用户自己拥有在权限 #################################
        HttpSession session = request.getSession();
        User user_db = (User) session.getAttribute("USER");

        // 1、登录用户信息ID,查询拥有的菜单
        int userId = user_db.getUserId();
        List<Permission> firstLvMenuList = permissionService.queryUser_xz_permissionByUserId(userId);

        // 2、实例化HashMap
        HashMap<Integer, List<Permission>> menuLvMap = new HashMap<Integer, List<Permission>>();

        firstLvMenuList.parallelStream()
                .forEach(permission -> {
                    System.err.println("------------1---父级-------------" + permission);
                    //查询子节点
                    int pId = permission.getPermissionId();
                    List<Permission> permissionSelectedListSon = permissionService.queryXZPermissionAllSonByPId(pId, userId);
                    for (Permission permission1 : permissionSelectedListSon) {
                        System.err.println("----------2-----子级-------------" + permission1);
                    }
                    // 维护父节点和子节点关系
                    menuLvMap.put(pId, permissionSelectedListSon);
                });
        //返回数据
        request.setAttribute("firstLvMenuList", firstLvMenuList);
        request.setAttribute("menuLvMap", menuLvMap);


        //######################## 登录用户自己拥有在权限 #################################
        return "view/frame/left.jsp";
    }
}
