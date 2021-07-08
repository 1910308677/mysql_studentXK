package com.lps.controller;

import com.lps.modle.Course;
import frame.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class XkController extends BaseController {
    public String list(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        //3.调用业务。
        List<Course> courseList_db = courseService.queryAllCourse();
        //返回数据
        request.setAttribute("courseList_db", courseList_db);
        //2.跳转页面；
        return "view/system/course/courseList.jsp";
    }
    public String add(HttpServletRequest request, HttpServletResponse response) {

        //1.接受数据；
        String curriculum = request.getParameter("curriculum");
        String teacher = request.getParameter("teacher");
        String time = request.getParameter("time");
        int credit = Integer.parseInt(request.getParameter("credit"));

        //封装
        Course course = new Course();
        course.setCurriculum(curriculum);
        course.setTeacher(teacher);
        course.setTime(time);
        course.setCredit(credit);
        System.err.println(course);
        //3.调用业务。
        int n = courseService.addCourseByCourse(course);
        //2.跳转页面；
        //准备数据
        List<Course> courseList_db = courseService.queryAllCourse();
        //返回数据
        request.setAttribute("courseList_db", courseList_db);
        //2.跳转页面；
        return "view/system/course/courseList.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String courseIdSTR = request.getParameter("courseIdSTR");
        //字符类型转数组类型
        int courseId = Integer.parseInt(courseIdSTR);

        //3.调用业务。
        int n = courseService.deleteCourseBycourseId(courseId);

        //2.跳转页面；
        //准备数据
        List<Course> courseList_db = courseService.queryAllCourse();
        //返回数据
        request.setAttribute("courseList_db", courseList_db);
        //2.跳转页面；
        return "view/system/course/courseList.jsp";
    }

    public String updateUI(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String courseIdSTR = request.getParameter("courseIdSTR");
        //字符类型转数组类型
        int courseId = Integer.parseInt(courseIdSTR);
        System.err.println(courseId);
        //3.调用业务。
        Course course_db = courseService.queryCourseByCourseId(courseId);
        System.out.println(course_db);
        //返回修改数据
        request.setAttribute("course_db", course_db);

        //2.跳转页面；

        return "view/system/course/updateCourse.jsp";
    }


    public String update(HttpServletRequest request, HttpServletResponse response) {
        //1.接受数据；
        String courseIdSTR = request.getParameter("courseIdSTR");

        //字符类型转数组类型
        int courseId = Integer.parseInt(courseIdSTR);

        String curriculum = request.getParameter("curriculum");
        String teacher = request.getParameter("teacher");
        String time = request.getParameter("time");
        int credit = Integer.parseInt(request.getParameter("credit"));

        Course course = new Course();
        course.setCourseId(courseId);
        course.setCurriculum(curriculum);
        course.setTeacher(teacher);
        course.setTime(time);
        course.setCredit(credit);

        //3.调用业务。
        int n = courseService.updateCourseByCourse(course);

        //2.跳转页面；
        //准备数据
        List<Course> courseList_db = courseService.queryAllCourse();
        request.setAttribute("courseList_db", courseList_db);
        return "view/system/course/courseList.jsp";
    }

}
