package com.sunhao.onlineexambackend.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 题库表 Mapper 接口
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface QuestionMapper extends BaseMapper<Question> {

    List<Question> getQuestionsByTypeAndSubject(String subject, Integer type);
}
