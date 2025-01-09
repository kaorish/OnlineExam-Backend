package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.ExamWithStatusDTO;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.sunhao.onlineexambackend.enums.ExamStatus;
import com.sunhao.onlineexambackend.service.serviceimpl.ExamServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 考试表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
public class ExamController {

    @Resource
    private ExamServiceImpl examService;

    /**
     * 分页查询所有考试 不含状态
     * 示例请求: GET /exams/noStatus?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/exams/noStatus")
    public ResultUtil getExams(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Exam> examPage = new Page<>(page, size);
        IPage<Exam> res = examService.getExams(examPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有考试不含状态", res);
        } else {
            return ResultUtil.isFail(404, "未查询到考试");
        }
    }

    /**
     * 根据考试编号查询考试
     * 示例请求: GET /exam?id=1
     *
     * @param id 考试编号
     * @return 考试信息
     */
    @GetMapping("/exam")
    public ResultUtil getExam(@RequestParam("id") Integer id) {
        Exam res = examService.getExam(id);
        if (res != null) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到考试");
        }
    }

    /**
     * 分页查询所有考试及其状态
     * 示例请求: GET /exams/status?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/exams/status")
    public ResultUtil getAllExamsWithStatus(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        IPage<ExamWithStatusDTO> res = examService.getAllExamsWithStatus(page, size);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有考试及其状态成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到考试");
        }
    }

    /**
     * 分页根据状态查询考试
     * 示例请求: GET /exams?status=1&page=1&size=10
     *
     * @param status 状态码（0未开始，1进行中，2已结束）
     * @param page   当前页码
     * @param size   每页记录数
     * @return 分页结果
     */
    @GetMapping("/exams")
    public ResultUtil getExamsByStatus(
            @RequestParam(value = "status", defaultValue = "1") Integer status,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        ExamStatus examStatus;
        try {
            examStatus = ExamStatus.fromCode(status);
        } catch (IllegalArgumentException e) {
            return ResultUtil.isFail(400, "无效的状态码");
        }

        IPage<ExamWithStatusDTO> res = examService.getExamsByStatus(examStatus, page, size);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询指定状态考试成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到该状态的考试");
        }
    }

    /**
     * 分页根据科目模糊查询考试
     * 示例请求: GET /exams/bySubject?subject=数学&page=1&size=10
     *
     * @param subject 科目
     * @param page    当前页码
     * @param size    每页记录数
     * @return 分页结果
     */
    @GetMapping("/exams/bySubject")
    public ResultUtil getExamsBySubject(
            @RequestParam(value = "subject") String subject,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Exam> examPage = new Page<>(page, size);
        IPage<Exam> res = examService.getExamsBySubject(subject, examPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页模糊查询科目考试成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到考试");
        }
    }

    /**
     * 添加考试
     * 示例请求: POST /exam
     *
     * @param exam 考试信息
     * @return 添加结果
     */
    @PostMapping("/exam")
    public ResultUtil addExam(@RequestBody Exam exam) {
        int res = examService.addExam(exam);
        if (res == 1) {
            return ResultUtil.isSuccess("添加成功", res);
        } else {
            return ResultUtil.isFail(500, "添加失败");
        }
    }

    /**
     * 更新考试
     * 示例请求: PUT /exam
     *
     * @param exam 考试信息
     * @return 更新结果
     */
    @PutMapping("/exam")
    public ResultUtil updateExam(@RequestBody Exam exam) {
        int res = examService.updateExam(exam);
        if (res == 1) {
            return ResultUtil.isSuccess("更新成功", res);
        } else {
            return ResultUtil.isFail(500, "更新失败");
        }
    }

    /**
     * 删除考试
     * 示例请求: DELETE /exam?id=1
     *
     * @param id 考试编号
     * @return 删除结果
     */
    @DeleteMapping("/exam")
    public ResultUtil deleteExam(@RequestParam("id") Integer id) {
        int res = examService.deleteExam(id);
        if (res == 1) {
            return ResultUtil.isSuccess("删除成功", res);
        } else {
            return ResultUtil.isFail(500, "删除失败");
        }
    }
}
