package com.sunhao.onlineexambackend.service.serviceimpl;

import com.sunhao.onlineexambackend.entity.po.Question;
import com.sunhao.onlineexambackend.mapper.QuestionMapper;
import com.sunhao.onlineexambackend.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
