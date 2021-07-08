package com.lps.modle;

public class Curriculum {
    private int curriculumId;
    //用户ID
    private int userId;
    //课程Id
    private int courseId;
    //课程名称
    private String curriculum;
    //任课教师
    private String teacher;
    //课程时间
    private String time;
    //學分
    private int credit;

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

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

    @Override
    public String toString() {
        return "Curriculum{" +
                "userID=" + userId +
                ", courseID=" + courseId +
                ", curriculum='" + curriculum + '\'' +
                ", teacher='" + teacher + '\'' +
                ", time='" + time + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
