package com.sunhao.onlineexambackend.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 题库表 Mapper 接口
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface QuestionMapper extends BaseMapper<Question> {

    IPage<Question> selectPageBySubject(Page<Question> questionPage, String subject);
}
