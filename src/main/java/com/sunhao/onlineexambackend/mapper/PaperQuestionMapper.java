package com.sunhao.onlineexambackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.entity.po.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperQuestionMapper extends BaseMapper<PaperQuestion> {
    IPage<Question> getPaperQuestions(Page<PaperQuestion> paperQuestionPage, @Param("paper_id") Integer paper_id);

    List<Question> getPaperQuestionsNoPage(Integer paper_id);
}
