package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.sunhao.onlineexambackend.service.PaperQuestionService;
import com.sunhao.onlineexambackend.service.serviceimpl.PaperQuestionServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class PaperQuestionController {

    @Resource
    private PaperQuestionServiceImpl paperQuestionService;

    /**
     * 根据试卷id获取试卷题目，不分数组
     * @param paper_id
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/paperQuestions")
    public ResultUtil getPaperQuestions(
            @RequestParam(value = "paper_id") Integer paper_id,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {

        Page<PaperQuestion> paperQuestionPage = new Page<>(page, size);
        IPage<Question> res = paperQuestionService.getPaperQuestions(paperQuestionPage, paper_id);
        if (res != null) {
            return ResultUtil.isSuccess("获取试卷题目成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到题目");
        }
    }

    /**
     * 根据试卷id获取试卷题目，分三个数组，0是选择题，1是填空题，2是判断题
     * @param paper_id
     * @return
     */
    @GetMapping("/paperQuestions/byMapping")
    public Map<Integer, List<Question>> getPaperQuestionsByMapping(@RequestParam(value = "paper_id") Integer paper_id) {

        List<Question> questions = paperQuestionService.getPaperQuestionsNoPage(paper_id);
//        if (questions == null) {
//            return ResultUtil.isFail(404, "未查询到题目");
//        }

        List<Question> Multiple = new ArrayList<>(); // 选择题
        List<Question> Fill = new ArrayList<>(); // 填空题
        List<Question> Judge = new ArrayList<>(); // 判断题

        for (Question question : questions) {
            if (question.getType() == 0) {
                Multiple.add(question);
            } else if (question.getType() == 1) {
                Fill.add(question);
            } else if (question.getType() == 2) {
                Judge.add(question);
            }
        }

//        List<List<Question>> res = Arrays.asList(Multiple, Fill, Judge);
//
//        return ResultUtil.isSuccess("获取试卷题目成功", res);

        Map<Integer, List<Question>> map = new HashMap<>();
        map.put(1, Multiple);
        map.put(2, Fill);
        map.put(3, Judge);
        return map;
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
