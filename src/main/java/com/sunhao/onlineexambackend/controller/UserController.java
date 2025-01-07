package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.UpdatePwdDTO;
import com.sunhao.onlineexambackend.entity.po.User;
import com.sunhao.onlineexambackend.service.serviceimpl.UserServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

//    学生

    /**
     * 分页查询所有学生
     * 示例请求: GET /user/students?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/students")
    public ResultUtil getStudents(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<User> studentPage = new Page<>(page, size);
        IPage<User> res = userService.getStudents(studentPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有学生", res);
        } else {
            return ResultUtil.isFail(404, "未查询到学生");
        }
    }

    /**
     * 根据ID查询学生
     * 示例请求: GET /user/student?id=1
     *
     * @param id 学生ID
     * @return 学生信息
     */
    @GetMapping("/student")
    public ResultUtil getStudentById(@RequestParam("id") String id) {
        User res = userService.getStudentById(id);
        if (res != null) {
            return ResultUtil.isSuccess(res);
        } else {
            return ResultUtil.isFail(404, "未查询到该学生");
        }
    }

    /**
     * 添加学生
     * 示例请求: POST /user/student
     *
     * @param user 学生信息
     * @return 添加结果
     */
    @PostMapping("/student")
    public ResultUtil addStudent(@RequestBody User user) {
        int res = userService.addStudent(user);
        if (res == 1) {
            return ResultUtil.isSuccess("添加成功", null);
        } else {
            return ResultUtil.isFail(500, "添加失败");
        }
    }

    /**
     * 更新学生信息待做
     */

    /**
     * 重置学生密码
     * 示例请求: PUT /user/student
     *
     * @param user 学生信息
     * @return 更新结果
     */
    @PutMapping("/student")
    public ResultUtil updateStudentPwd(@RequestBody UpdatePwdDTO updatePwdDTO) {
        int res = userService.updateStudentPwd(updatePwdDTO);
        if (res == 1) {
            return ResultUtil.isSuccess("更新成功", null);
        } else {
            return ResultUtil.isFail(500, "更新失败");
        }
    }

    /**
     * 删除学生
     * 示例请求: DELETE /user/student?id=1
     *
     * @param id 学生ID
     * @return 删除结果
     */
    @DeleteMapping("/student")
    public ResultUtil deleteStudent(@RequestParam("id") String id) {
        int res = userService.deleteStudent(id);
        if (res == 1) {
            return ResultUtil.isSuccess("删除成功", null);
        } else {
            return ResultUtil.isFail(500, "删除失败");
        }
    }

//    老师
    /**
     * 分页查询所有老师
     * 示例请求: GET /user/teachers?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/teachers")
    public ResultUtil getTeachers(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<User> teacherPage = new Page<>(page, size);
        IPage<User> res = userService.getTeachers(teacherPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有老师", res);
        } else {
            return ResultUtil.isFail(404, "未查询到老师");
        }
    }

    /**
     * 根据ID查询老师
     * 示例请求: GET /user/teacher?id=1
     *
     * @param id 老师ID
     * @return 老师信息
     */
    @GetMapping("/teacher")
    public ResultUtil getTeacherById(@RequestParam("id") String id) {
        User res = userService.getTeacherById(id);
        if (res != null) {
            return ResultUtil.isSuccess(res);
        } else {
            return ResultUtil.isFail(404, "未查询到该老师");
        }
    }

    /**
     * 添加老师
     * 示例请求: POST /user/teacher
     *
     * @param user 老师信息
     * @return 添加结果
     */
    @PostMapping("/teacher")
    public ResultUtil addTeacher(@RequestBody User user) {
        int res = userService.addTeacher(user);
        if (res == 1) {
            return ResultUtil.isSuccess("添加成功", null);
        } else {
            return ResultUtil.isFail(500, "添加失败");
        }
    }

    /**
     * 更新老师信息待做
     */


    /**
     * 删除老师
     * 示例请求: DELETE /user/teacher?id=1
     *
     * @param id 老师ID
     * @return 删除结果
     */
    @DeleteMapping("/teacher")
    public ResultUtil deleteTeacher(@RequestParam("id") String id) {
        int res = userService.deleteTeacher(id);
        if (res == 1) {
            return ResultUtil.isSuccess("删除成功", null);
        } else {
            return ResultUtil.isFail(500, "删除失败");
        }
    }

//    管理员
    /**
     * 分页查询所有管理员
     * 示例请求: GET /user/admins?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/admins")
    public ResultUtil getAdmins(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<User> adminPage = new Page<>(page, size);
        IPage<User> res = userService.getAdmins(adminPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有管理员", res);
        } else {
            return ResultUtil.isFail(404, "未查询到管理员");
        }
    }


    /**
     * 根据ID查询管理员
     * 示例请求: GET /user/admin?id=1
     *
     * @param id 管理员ID
     * @return 管理员信息
     */
    @GetMapping("/admin")
    public ResultUtil getAdminById(@RequestParam("id") String id) {
        User res = userService.getAdminById(id);
        if (res != null) {
            return ResultUtil.isSuccess(res);
        } else {
            return ResultUtil.isFail(404, "未查询到该管理员");
        }
    }

    /**
     * 添加管理员待做
     * 更新管理员信息待做
     * 删除管理员待做
     */


}