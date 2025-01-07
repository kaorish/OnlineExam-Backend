package com.sunhao.onlineexambackend.service.serviceimpl;

import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.mapper.PaperQuestionMapper;
import com.sunhao.onlineexambackend.service.PaperQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class PaperQuestionServiceImpl implements PaperQuestionService {

    @Resource
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public int addPaperQuestion(PaperQuestion paperQuestion) {
        return paperQuestionMapper.insert(paperQuestion);
    }
}
