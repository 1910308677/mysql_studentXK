package com.lps.controller;

import com.lps.modle.Curriculum;
import com.lps.modle.User;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TableController extends BaseController {

    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        User user = (User) request.getSession().getAttribute("USER");
        if (user == null) {
            return "login.jsp";
        }

        //3.user调用业务。
        //封装
        List<Curriculum> tableList_db = tableService.queryAllTable(user.getUserId());
        //返回数据
        request.setAttribute("tableList_db", tableList_db);
        //2.跳转页面；
        return "view/system/table/tableList.jsp";
    }
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String curriculumIdSTR = request.getParameter("curriculumIdSTR");
        //字符类型转数组类型
        int userId = Integer.parseInt(curriculumIdSTR);

        //3.调用业务。
        int n = tableService.queryUserByUserId(userId);
        System.err.print(n);


        //2.跳转页面；
        //准备数据
        List<Curriculum> tableList_db = tableService.queryAllTable(userId);
        request.setAttribute("tableList_db", tableList_db);
        return "view/system/table/tableList.jsp";
    }
}
