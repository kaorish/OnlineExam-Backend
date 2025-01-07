package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 题库表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IQuestionService extends IService<Question> {

    IPage<Question> getQustions(Page<Question> questionPage);

    IPage<Question> getQuestionsBySubject(Page<Question> questionPage, String subject);
}
