package com.lps.controller;

import com.lps.modle.Curriculum;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectController extends BaseController {
    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<Curriculum> curriculumList_db = curriculumService.queryAllCurriculum();
        //返回数据
        request.setAttribute("curriculumList_db", curriculumList_db);
        //2.跳转页面；
        return "view/system/select/selectList.jsp";
    }

    public String select(HttpServletRequest request, HttpServletResponse response){
        String userIdSTR = request.getParameter("userId");
        int userId = Integer.parseInt(userIdSTR);
        List<Curriculum> select_db = curriculumService.queryCurriculumByUserId(userId);
        request.setAttribute("select_db",select_db);
        return "view/system/select/selectResult.jsp";
    }
}
