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

    @GetMapping("/paperQuestion")
    public ResultUtil getPaperQuestion(
            @RequestParam(value = "paperId") Integer paperId,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        return null;
    }

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
