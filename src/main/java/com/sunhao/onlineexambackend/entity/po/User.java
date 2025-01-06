package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学工号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 学院
     */
    private String institute;

    /**
     * 专业
     */
    private String major;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String classes;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色(0管理员，1教师，2学生)
     */
    private Integer role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
            "id = " + id +
            ", username = " + username +
            ", gender = " + gender +
            ", password = " + password +
            ", institute = " + institute +
            ", major = " + major +
            ", grade = " + grade +
            ", classes = " + classes +
            ", tel = " + tel +
            ", email = " + email +
            ", role = " + role +
        "}";
    }
}
