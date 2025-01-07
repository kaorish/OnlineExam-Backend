package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.sunhao.onlineexambackend.service.serviceimpl.ExamServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 考试表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
@RequestMapping("/exam")
public class ExamController {

    @Resource
    private ExamServiceImpl examService;

    /**
     * 分页查询所有考试
     * 示例请求: GET /exam/all?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/all")
    public ResultUtil getExams(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Exam> examPage = new Page<>(page, size);
        IPage<Exam> res = examService.getExams(examPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有考试", res);
        } else {
            return ResultUtil.isFail(400, "查询失败");
        }
    }

}
