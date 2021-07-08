package com.lps.controller;

import com.lps.modle.*;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SelectionController extends BaseController {
    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<Course> courseList_db = selectionService.queryAllCourse();
        //返回数据
        request.setAttribute("courseList_db",courseList_db);
        //2.跳转页面；
        return "view/system/selection/selectionList.jsp";
    }
    public String fpPermissionUI(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        String userIdSTR = request.getParameter("userIdSTR");
        //字符转数字
        int userId = Integer.parseInt(userIdSTR);


        //3.调用业务。
        //a.分配角色
        User user_db = userService.queryUserByUserId(userId);
        request.setAttribute("user_db", user_db);
        System.out.println("----------------user_db-------------" + user_db);

        //b.权限数据
        List<Course> courseList_db = selectionService.queryAllCourse();
        request.setAttribute("courseList_db", courseList_db);

        //d.选中权限集合 (XZ:选中)
        List<Course> XZCourseList_db = selectionService.queryXZCourseByUserId(userId);
        List<Integer> list = new ArrayList<Integer>();
        for (Course  course : XZCourseList_db) {
            list.add(course.getCourseId());
        }
        request.setAttribute("ids", list);

        //2.跳转页面；
        return "view/system/permission/selection.jsp";
    }
    public String fpPermission(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //角色ID
        Object userObj = request.getSession().getAttribute("USER");
        if (userObj == null) {
            return "login.jsp";
        }
        User user = (User)userObj;
        //字符转数字
        int userId = user.getUserId();
        System.out.println("---------userId-----------" + userId);

        //--->先删除
        int m = selectionService.deleteCurriculumByUserId(userId);
        //权限ID
        String[] courseIdSTRs = request.getParameterValues("courseIds");
        //遍历
        for (String courseIdSTR : courseIdSTRs) {
            //字符转数字
            int courseId = Integer.parseInt(courseIdSTR);
            System.out.println("----------courseId----------" + courseId);
            Course course = courseService.queryCourseByCourseId(courseId);

            //3.调用业务。
            //封装
            Curriculum curriculum = new Curriculum();
            curriculum.setUserId(userId);
            curriculum.setCourseId(courseId);
            curriculum.setCurriculum(course.getCurriculum());
            curriculum.setTeacher(course.getTeacher());
            curriculum.setTime(course.getTime());
            curriculum.setCredit(course.getCredit());
            //调用业务
            int n = curriculumService.addCurriculumByCurriculum(curriculum);
        }


        //2.跳转页面；
        //a.分配角色
        User user_db = selectionService.queryUserByUserId(userId);
        request.setAttribute("user_db", user_db);

        //b.权限数据
        List<Course> courseList_db = selectionService.queryAllCourse();
        request.setAttribute("courseList_db", courseList_db);

        //c.友情提示
        request.setAttribute("message", "选课成功，是否继续选课？");

        //d.选中权限集合 (XZ:选中)

//        List XZPermissionList_db = permissionService.queryXZPermissionByRoleId(roleId);
//        request.setAttribute("XZPermissionList_db", XZPermissionList_db);
//        for (Object XZPermission : XZPermissionList_db) {
//            System.out.println("_______XZPermissionList_db_______" + XZPermission);
//        }


        List<Course> XZCourseList_db = selectionService.queryXZCourseByUserId(userId);
        List<Integer> list = new ArrayList<Integer>();
        for (Course course : XZCourseList_db) {
            list.add(course.getCourseId());
        }
        request.setAttribute("ids", list);
        return "view/system/selection/selection.jsp";
    }
}
