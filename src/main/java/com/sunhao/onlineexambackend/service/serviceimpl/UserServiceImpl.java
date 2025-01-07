package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.UpdatePwdDTO;
import com.sunhao.onlineexambackend.entity.po.User;
import com.sunhao.onlineexambackend.mapper.UserMapper;
import com.sunhao.onlineexambackend.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunhao.onlineexambackend.util.HashPasswordWithSalt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> getStudents(Page<User> studentPage) {
        return userMapper.getStudents(studentPage);
    }

    @Override
    public User getStudentById(String id) {
        return userMapper.getStudentById(id);
    }


    public int addStudent(User user) {
        return userMapper.addStudent(user);
    }

    @Override
    public int updateStudentPwd(UpdatePwdDTO updatePwdDTO) {
        User user = userMapper.getStudentById(updatePwdDTO.getId());
        String salt = user.getSalt();
        System.out.println("id:" + user.getId());
        System.out.println("salt: " + salt);
        System.out.println("oldPwdHash: " + user.getPassword());
        System.out.println("newPwd: " + updatePwdDTO.getNewPassword());
        String password = HashPasswordWithSalt.hashPasswordWithSalt(updatePwdDTO.getNewPassword(), salt);
        user.setPassword(password);
        System.out.println("newPwdHash: " + user.getPassword());
        return userMapper.updateStudentPwd(user);
    }

    @Override
    public int deleteStudent(String id) {
        return userMapper.deleteStudent(id);
    }

    @Override
    public IPage<User> getTeachers(Page<User> teacherPage) {
        return userMapper.getTeachers(teacherPage);
    }

    @Override
    public User getTeacherById(String id) {
        return userMapper.getTeacherById(id);
    }

    public int addTeacher(User user) {
        return userMapper.addTeacher(user);
    }

    public int deleteTeacher(String id) {
        return userMapper.deleteTeacher(id);
    }

    @Override
    public IPage<User> getAdmins(Page<User> adminPage) {
        return userMapper.getAdmins(adminPage);
    }

    @Override
    public User getAdminById(String id) {
        return userMapper.getAdminById(id);
    }
}
