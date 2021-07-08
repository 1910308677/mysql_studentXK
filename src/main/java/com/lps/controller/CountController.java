package com.lps.controller;

import com.lps.modle.Curriculum;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CountController extends BaseController {
    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<Curriculum> curriculumList_db = curriculumService.queryAllCurriculum();
        //返回数据
        request.setAttribute("curriculumList_db", curriculumList_db);
        //2.跳转页面；
        return "view/system/count/countList.jsp";
    }
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String curriculumIdSTR = request.getParameter("curriculumIdSTR");
        //字符类型转数组类型
        int userId = Integer.parseInt(curriculumIdSTR);

        //3.调用业务。
        int n = curriculumService.deleteUserByUserId(userId);
        System.err.print(n);


        //2.跳转页面；
        //准备数据
        List<Curriculum> curriculumList_db = curriculumService.queryAllCurriculum();
        request.setAttribute("curriculumList_db", curriculumList_db);
        return "view/system/count/countList.jsp";
    }
}
