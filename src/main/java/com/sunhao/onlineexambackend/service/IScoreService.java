package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Score;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IScoreService extends IService<Score> {

    IPage<Score> getScores(Page<Score> scorePage);

    IPage<Score> getScoresByUserId(Page<Score> scorePage, String userId);

    IPage<Score> getScoresByExamId(Page<Score> scorePage, Integer examId);

    int addScore(Score score);

    int deleteScore(Integer id);
}
