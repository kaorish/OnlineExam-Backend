package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.sunhao.onlineexambackend.mapper.PaperQuestionMapper;
import com.sunhao.onlineexambackend.mapper.QuestionMapper;
import com.sunhao.onlineexambackend.service.PaperQuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class PaperQuestionServiceImpl implements PaperQuestionService {

    @Resource
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public int addPaperQuestion(PaperQuestion paperQuestion) {
        return paperQuestionMapper.insert(paperQuestion);
    }

    @Override
    public IPage<Question> getPaperQuestions(Page<PaperQuestion> paperQuestionPage, Integer paper_id) {
        return paperQuestionMapper.getPaperQuestions(paperQuestionPage, paper_id);
    }

    @Override
    public List<Question> getPaperQuestionsNoPage(Integer paper_id) {
        return paperQuestionMapper.getPaperQuestionsNoPage(paper_id);
    }
}
