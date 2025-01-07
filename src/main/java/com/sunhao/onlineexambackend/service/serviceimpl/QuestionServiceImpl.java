package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Paper;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.sunhao.onlineexambackend.mapper.QuestionMapper;
import com.sunhao.onlineexambackend.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 题库表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public IPage<Question> getQustions(Page<Question> questionPage) {
        return questionMapper.selectPage(questionPage, null);
    }

    @Override
    public IPage<Question> getQuestionsBySubject(Page<Question> questionPage, String subject) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject", subject);
        return questionMapper.selectPage(questionPage, queryWrapper);
    }
}
