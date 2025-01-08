package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Score;
import com.sunhao.onlineexambackend.mapper.ScoreMapper;
import com.sunhao.onlineexambackend.service.IScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public IPage<Score> getScores(Page<Score> scorePage) {
        return scoreMapper.selectPage(scorePage, null);
    }

    @Override
    public IPage<Score> getScoresByUserId(Page<Score> scorePage, Integer userId) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return scoreMapper.selectPage(scorePage, queryWrapper);
    }

    @Override
    public IPage<Score> getScoresByExamId(Page<Score> scorePage, Integer examId) {
        QueryWrapper<Score> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id", examId);
        return scoreMapper.selectPage(scorePage, queryWrapper);
    }

    @Override
    public int addScore(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public int deleteScore(Integer id) {
        return scoreMapper.deleteById(id);
    }
}
