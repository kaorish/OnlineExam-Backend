package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.entity.po.Question;

import java.util.List;

public interface PaperQuestionService {
    int addPaperQuestion(PaperQuestion paperQuestion);

    IPage<Question> getPaperQuestions(Page<PaperQuestion> paperQuestionPage, Integer paperId);

    List<Question> getPaperQuestionsNoPage(java.lang.Integer paperId);
}
