package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.sunhao.onlineexambackend.service.serviceimpl.QuestionServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 题库表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
public class QuestionController {

    @Resource
    private QuestionServiceImpl questionService;

    /**
     * 分页查询所有题目
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/questions")
    public ResultUtil getQuestions(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Question> questionPage = new Page<>(page, size);
        IPage<Question> res = questionService.getQustions(questionPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有题目成功", res);
        } else {
            return ResultUtil.isFail(404, "分页查询所有题目失败");
        }
    }

    /**
     * 根据id查询题目
     * @param id
     * @return
     */
    @GetMapping("/question")
    public ResultUtil getQuestion(@RequestParam(value = "id") Integer id) {
        Question res = questionService.getById(id);
        if (res != null) {
            return ResultUtil.isSuccess("查询题目成功", res);
        } else {
            return ResultUtil.isFail(404, "查询题目失败");
        }
    }

    /**
     * 根据科目分页查询题目
     * @param subject
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/questions/bySubject")
    public ResultUtil getQuestionsBySubject(@RequestParam(value = "subject") String subject,
                                            @RequestParam(value = "page", defaultValue = "1") Integer page,
                                            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Question> questionPage = new Page<>(page, size);
        IPage<Question> res = questionService.getQuestionsBySubject(questionPage, subject);
        if (res != null) {
            return ResultUtil.isSuccess("根据科目分页查询题目成功", res);
        } else {
            return ResultUtil.isFail(404, "根据科目分页查询题目失败");
        }
    }

    /**
     * 添加题目
     * @param question
     * @return
     */
    @PostMapping("/question")
    public ResultUtil addQuestion(@RequestBody Question question) {
        boolean res = questionService.save(question);
        if (res) {
            return ResultUtil.isSuccess("添加题目成功", null);
        } else {
            return ResultUtil.isFail(500, "添加题目失败");
        }
    }

    /**
     * 更新题目
     * @param question
     * @return
     */
    @PutMapping("/question")
    public ResultUtil updateQuestion(@RequestBody Question question) {
        boolean res = questionService.updateById(question);
        if (res) {
            return ResultUtil.isSuccess("更新题目成功", null);
        } else {
            return ResultUtil.isFail(500, "更新题目失败");
        }
    }

    /**
     * 根据id删除题目
     * @param id
     * @return
     */
    @DeleteMapping("/question")
    public ResultUtil deleteQuestion(@RequestParam(value = "id") Integer id) {
        boolean res = questionService.removeById(id);
        if (res) {
            return ResultUtil.isSuccess("删除题目成功", null);
        } else {
            return ResultUtil.isFail(500, "删除题目失败");
        }
    }
}
