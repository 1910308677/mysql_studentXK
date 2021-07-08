package com.lps.modle;


public class Course {
    private int courseId;
    //课程号
    private String curriculum;
    //课程名
    private String teacher;
    //任课老师
    private String time;
    //时间
    private int credit;
    //学分


    public int getCourseId() {
        return courseId;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTime() {
        return time;
    }

    public int getCredit() {
        return credit;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", curriculum='" + curriculum + '\'' +
                ", teacher='" + teacher + '\'' +
                ", time='" + time + '\'' +
                ", credit=" + credit +
                '}';
    }
}
