package com.lps.controller;

import com.lps.modle.Role;
import com.lps.modle.User;
import com.lps.modle.UserRole;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RoleController extends BaseController {

    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<Role> roleList_db = roleService.queryAllRole();
        //返回数据
        request.setAttribute("roleList_db", roleList_db);
        //2.跳转页面；
        return "view/system/role/roleList.jsp";
    }

    public String fpRoleUI(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //用户ID
        String userIdSTR = request.getParameter("userIdSTR");
        //字符类型转数字
        int userId = Integer.parseInt(userIdSTR);

        //3.调用业务。
        //a.分配用户
        User user_db = userService.queryUserByUserId(userId);
        request.setAttribute("user_db", user_db);

        //b.角色数据
        List<Role> roleList_db = roleService.queryAllRole();
        //返回数据
        request.setAttribute("roleList_db", roleList_db);
        //d.选择数据
        Role XZRole = roleService.queryXZRoleByUserId(userId);
        request.setAttribute("XZRole", XZRole);
        System.out.println("--------------fpRole()---------------"+XZRole);

        //2.跳转页面；
        return "view/system/role/fpRole.jsp";
    }
    public String fpRole(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //用户ID
        String userIdSTR = request.getParameter("userIdSTR");
        //字符类型转数字
        int userId = Integer.parseInt(userIdSTR);


        //角色ID
        String roleIdSTR = request.getParameter("roleIdSTR");
        //字符类型转数字
        int roleId = Integer.parseInt(roleIdSTR);

        //---》先删除
        int m = userRoleService.deleteUserRoleByUserId(userId);
        //3.调用业务。
        //封装
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        //保存
        int n = userRoleService.addUserRoleByUserRole(userRole);


        //2.跳转页面；
        //a.分配用户
        User user_db = userService.queryUserByUserId(userId);
        request.setAttribute("user_db", user_db);

        //b.角色数据
        List<Role> roleList_db = roleService.queryAllRole();
        request.setAttribute("roleList_db", roleList_db);

        //c.友情提示
        request.setAttribute("message", "角色分配成功，继续分配吗？");
        //d.选择数据
        Role XZRole = roleService.queryXZRoleByUserId(userId);
        request.setAttribute("XZRole", XZRole);
        System.out.println("--------------fpRole()---------------"+XZRole);
        return "view/system/role/fpRole.jsp";
    }
    public String add(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        String name = request.getParameter("name");
        String state = request.getParameter("state");

        //封装
        Role role = new Role();
        role.setName(name);
        role.setState(state);
        //3.调用业务。
        int n = roleService.addRoleByRole(role);
        ;
        //2.跳转页面；
        //准备数据
        List<Role> roleList_db = roleService.queryAllRole();
        //返回数据
        request.setAttribute("roleList_db", roleList_db);
        //2.跳转页面；
        return "view/system/role/roleList.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String roleIdSTR = request.getParameter("roleIdSTR");
        //字符类型转数组类型
        int roleId = Integer.parseInt(roleIdSTR);

        //3.调用业务。
        int n = roleService.deleteRoleByroleId(roleId);

        //2.跳转页面；
        //准备数据
        List<Role> roleList_db = roleService.queryAllRole();
        //返回数据
        request.setAttribute("roleList_db", roleList_db);
        //2.跳转页面；
        return "view/system/role/roleList.jsp";
    }

    public String updateUI(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String roleIdSTR = request.getParameter("roleIdSTR");
        //字符类型转数组类型
        int roleId = Integer.parseInt(roleIdSTR);
        System.err.println(roleId);
        //3.调用业务。
        Role role_db = roleService.queryRoleByRoleId(roleId);
        System.out.println(role_db);
        //返回修改数据
        request.setAttribute("role_db", role_db);

        //2.跳转页面；

        return "view/system/role/updateRole.jsp";
    }


    public String update(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String roleIdSTR = request.getParameter("roleIdSTR");

        //字符类型转数组类型
        int roleId = Integer.parseInt(roleIdSTR);

        String name = request.getParameter("name");
        String state = request.getParameter("state");
        Role role = new Role();
        role.setRoleId(roleId);
        role.setName(name);
        role.setState(state);

        //3.调用业务。
        int n = roleService.updateRoleByRole(role);

        //2.跳转页面；
        //准备数据
        List<Role> roleList_db = roleService.queryAllRole();
        request.setAttribute("roleList_db", roleList_db);
        return "view/system/role/roleList.jsp";
    }

}
