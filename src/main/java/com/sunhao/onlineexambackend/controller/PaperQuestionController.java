package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.service.PaperQuestionService;
import com.sunhao.onlineexambackend.service.serviceimpl.PaperQuestionServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaperQuestionController {

    @Resource
    private PaperQuestionServiceImpl paperQuestionService;

    /**
     * 根据试卷id获取试卷题目，分三个数组，0是选择题，1是填空题，2是判断题
     * @param paperId
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/paperQuestions")
    public ResultUtil getPaperQuestion(
            @RequestParam(value = "paperId") Integer paperId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Page<PaperQuestion> paperQuestionPage = new Page<>(page, size);
        return null;
    }

    /**
     * 添加试卷题目
     * @param paperQuestion
     * @return
     */
    @PostMapping("/paperQuestion")
    public ResultUtil addPaperQuestion(@RequestBody PaperQuestion paperQuestion) {
        int res = paperQuestionService.addPaperQuestion(paperQuestion);
        if (res == 1) {
            return ResultUtil.isSuccess("添加试卷题目成功", paperQuestion);
        } else {
            return ResultUtil.isFail(500, "添加试卷题目失败");
        }
    }
}
