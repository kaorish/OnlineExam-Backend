package com.sunhao.onlineexambackend.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> getStudents(Page<User> page);

    User getStudentById(String id);

    int addStudent(User user);

    int updateStudentPwd(User user);

    int deleteStudent(String id);

    IPage<User> getTeachers(Page<User> teacherPage);

    User getTeacherById(String id);

    int addTeacher(User user);

    int deleteTeacher(String id);

    IPage<User> getAdmins(Page<User> adminPage);

    User getAdminById(String id);

    int updateStudent(User user);

    int updateTeacher(User user);
}
