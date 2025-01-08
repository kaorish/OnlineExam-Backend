package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Score;
import com.sunhao.onlineexambackend.service.serviceimpl.ScoreServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 成绩表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
public class ScoreController {

    @Resource
    private ScoreServiceImpl scoreService;

    /**
     * 分页查询所有成绩
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/scores/all")
    public ResultUtil getScores(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Score> scorePage = new Page<>(page, size);
        IPage<Score> res = scoreService.getScores(scorePage);
        if (res != null && res.getTotal() > 0) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到成绩");
        }
    }

    /**
     * 根据学生id查询成绩
     * @param page
     * @param size
     * @param user_id
     * @return
     */
    @GetMapping("/scores/byUserId")
    public ResultUtil getScoresByUserId(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam("user_id") Integer user_id) {
        Page<Score> scorePage = new Page<>(page, size);
        IPage<Score> res = scoreService.getScoresByUserId(scorePage, user_id);
        if (res != null && res.getTotal() > 0) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到成绩");
        }
    }

    /**
     * 根据考试id查询成绩
     * @param page
     * @param size
     * @param exam_id
     * @return
     */
    @GetMapping("/scores/byExamId")
    public ResultUtil getScoresByExamId(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam("exam_id") Integer exam_id) {
        Page<Score> scorePage = new Page<>(page, size);
        IPage<Score> res = scoreService.getScoresByExamId(scorePage, exam_id);
        if (res != null && res.getTotal() > 0) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到成绩");
        }
    }

    /**
     * 添加成绩
     * @param score
     * @return
     */
    @PostMapping("/score")
    public ResultUtil addScore(@RequestBody Score score) {
        int res = scoreService.addScore(score);
        if (res == 1) {
            return ResultUtil.isSuccess("添加成功", res);
        } else {
            return ResultUtil.isFail(500, "添加失败");
        }
    }

    /**
     * 删除成绩
     * @param id
     * @return
     */
    @DeleteMapping("/score")
    public ResultUtil deleteScore(@RequestParam("id") Integer id) {
        int res = scoreService.deleteScore(id);
        if (res == 1) {
            return ResultUtil.isSuccess("删除成功", res);
        } else {
            return ResultUtil.isFail(500, "删除失败");
        }
    }
}
