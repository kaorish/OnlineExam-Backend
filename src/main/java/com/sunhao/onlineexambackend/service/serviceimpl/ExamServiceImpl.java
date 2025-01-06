package com.sunhao.onlineexambackend.service.serviceimpl;

import com.sunhao.onlineexambackend.entity.po.Exam;
import com.sunhao.onlineexambackend.mapper.ExamMapper;
import com.sunhao.onlineexambackend.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

}
