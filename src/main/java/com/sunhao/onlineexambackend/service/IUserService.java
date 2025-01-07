package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.UpdatePwdDTO;
import com.sunhao.onlineexambackend.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IUserService extends IService<User> {

    IPage<User> getStudents(Page<User> studentPage);

    User getStudentById(String id);

    int addStudent(User user);

    int updateStudentPwd(UpdatePwdDTO updatePwdDTO);

    int deleteStudent(String id);

    IPage<User> getTeachers(Page<User> teacherPage);

    User getTeacherById(String id);

    int addTeacher(User user);

    int deleteTeacher(String id);

    IPage<User> getAdmins(Page<User> adminPage);

    User getAdminById(String id);
}
