package com.lps.modle;

public class User {

    //用户ID
    private int userId;
    //姓名
    private String name;
    //性别
    private String sex;
    //年龄
    private String age;
    //地址
    private String adress;
    //电话
    private String tel;
    //QQ
    private String QQ;
    //微信
    private String wechat;
    //邮箱
    private String email;
    //用户名
    private String username;
    //密码
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(int userId, String name, String sex, String age, String adress, String tel, String QQ, String wechat, String email, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.adress = adress;
        this.tel = tel;
        this.QQ = QQ;
        this.wechat = wechat;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", adress='" + adress + '\'' +
                ", tel='" + tel + '\'' +
                ", QQ='" + QQ + '\'' +
                ", wechat='" + wechat + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
