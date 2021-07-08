package com.lps.controller;

import com.lps.modle.Permission;
import com.lps.modle.Role;
import com.lps.modle.RolePermission;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class PermissionController extends BaseController {

    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        for (Permission permission : permissionList_db) {
            System.out.println(permission);
        }
        //返回数据
        request.setAttribute("permissionList_db", permissionList_db);
        //2.跳转页面；
        return "view/system/permission/permissionList.jsp";
    }
    public String addUI(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        System.err.println("---------------PermissionController--------addUI()--");
        //3.调用业务。
        //父ID数据
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        request.setAttribute("permissionList_db", permissionList_db);

        //2.跳转页面；
        return "view/system/permission/addPermission.jsp";
    }

    public String add(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        //a.父ID数据
        String pIdSTR = request.getParameter("pIdSTR");
        //字符类型转成数字类型
        int pId = Integer.parseInt(pIdSTR);


        //b.表单数据
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String url = request.getParameter("url");
        String percode = request.getParameter("percode");
        String state = request.getParameter("state");

        //3.调用业务。
        //封装
        Permission permission = new Permission();
        permission.setpId(pId);
        permission.setName(name);
        permission.setType(type);
        permission.setUrl(url);
        permission.setPercode(percode);
        permission.setState(state);

        System.err.println("---------------PermissionController--------add()--" + permission);
        //调用业务
        int n = permissionService.addPermissionByPermission(permission);

        //2.跳转页面；
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        request.setAttribute("permissionList_db", permissionList_db);
        //2.跳转页面；
        return "view/system/permission/permissionList.jsp";
    }

    public String updateUI(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String permissionIdSTR = request.getParameter("permissionIdSTR");
        //字符类型转数组类型
        int permissionId = Integer.parseInt(permissionIdSTR);
        System.err.println(permissionId);
        //3.调用业务。
        //a.准备修改数据
        Permission permission_db = permissionService.queryPermissionByPermissionId(permissionId);
//        System.out.println(permission_db);
        request.setAttribute("permission_db", permission_db);

        //b.父ID数据
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        request.setAttribute("permissionList_db", permissionList_db);

        //c.数据选中
        //父ID
        int permissionId2 = permission_db.getpId();
        Permission permission_db_xz = permissionService.queryPermissionByPermissionId(permissionId2);
        request.setAttribute("permission_db_xz", permission_db_xz);
        System.out.println(permission_db_xz);
        //2.跳转页面；

        return "view/system/permission/updatePermission.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String permissionIdSTR = request.getParameter("permissionIdSTR");
        String pIdSTR = request.getParameter("pIdSTR");
        //字符类型转数组类型
        int permissionId = Integer.parseInt(permissionIdSTR);
        int pId = Integer.parseInt(pIdSTR);

        //b.表单数据
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String url = request.getParameter("url");
        String percode = request.getParameter("percode");
        String state = request.getParameter("state");

        //3.调用业务。
        //封装
        Permission permission = new Permission();
        permission.setPermissionId(permissionId);
        permission.setpId(pId);
        permission.setName(name);
        permission.setType(type);
        permission.setUrl(url);
        permission.setPercode(percode);
        permission.setState(state);
        //调用业务。
        int n = permissionService.updatePermissionByPermission(permission);


        //2.跳转页面；
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        request.setAttribute("permissionList_db", permissionList_db);
        return "view/system/permission/permissionList.jsp";
    }
    public String fpPermissionUI(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        String roleIdSTR = request.getParameter("roleIdSTR");
        //字符转数字
        int roleId = Integer.parseInt(roleIdSTR);


        //3.调用业务。
        //a.分配角色
        Role role_db = roleService.queryRoleByRoleId(roleId);
        request.setAttribute("role_db", role_db);
        System.out.println("----------------role_db-------------" + role_db);

        //b.权限数据
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        request.setAttribute("permissionList_db", permissionList_db);

        //d.选中权限集合 (XZ:选中)
        List<Permission> XZPermissionList_db = permissionService.queryXZPermissionByRoleId(roleId);
        List<Integer> list = new ArrayList<Integer>();
        for (Permission  permission : XZPermissionList_db) {
            list.add(permission.getPermissionId());
        }
        request.setAttribute("ids", list);

        //2.跳转页面；
        return "view/system/permission/fpPermission.jsp";
    }

    public String fpPermission(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //角色ID
        String roleIdSTR = request.getParameter("roleIdSTR");
        //字符转数字
        int roleId = Integer.parseInt(roleIdSTR);
        System.out.println("---------roleId-----------" + roleId);

        //--->先删除
        int m = rolePermissionService.deleteRolePermissionByRoleId(roleId);
        //权限ID
        String[] permissionIdSTRs = request.getParameterValues("permissionIdSTRs");
        //遍历
        for (String permissionIdSTR : permissionIdSTRs) {
            //字符转数字
            int permissionId = Integer.parseInt(permissionIdSTR);
            System.out.println("----------permissionId----------" + permissionId);

            //3.调用业务。
            //封装
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            //调用业务
            int n = rolePermissionService.addRolePermissionByRolePermission(rolePermission);
        }


        //2.跳转页面；
        //a.分配角色
        Role role_db = roleService.queryRoleByRoleId(roleId);
        request.setAttribute("role_db", role_db);

        //b.权限数据
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        request.setAttribute("permissionList_db", permissionList_db);

        //c.友情提示
        request.setAttribute("message", "权限分配成功，继续分配吗？");

        //d.选中权限集合 (XZ:选中)

//        List XZPermissionList_db = permissionService.queryXZPermissionByRoleId(roleId);
//        request.setAttribute("XZPermissionList_db", XZPermissionList_db);
//        for (Object XZPermission : XZPermissionList_db) {
//            System.out.println("_______XZPermissionList_db_______" + XZPermission);
//        }


        List<Permission> XZPermissionList_db = permissionService.queryXZPermissionByRoleId(roleId);
        List<Integer> list = new ArrayList<Integer>();
        for (Permission  permission : XZPermissionList_db) {
            list.add(permission.getPermissionId());
        }
        request.setAttribute("ids", list);

        return "view/system/permission/fpPermission.jsp";
    }
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String permissionIdSTR = request.getParameter("permissionIdSTR");
        //字符类型转数组类型
        int permissionId = Integer.parseInt(permissionIdSTR);

        //3.调用业务。
        int n = permissionService.deletePermissionBypermissionId(permissionId);

        //2.跳转页面；
        //准备数据
        List<Permission> permissionList_db = permissionService.queryAllPermission();
        //返回数据
        request.setAttribute("permissionList_db", permissionList_db);
        //2.跳转页面；
        return "view/system/permission/permissionList.jsp";
    }
}
