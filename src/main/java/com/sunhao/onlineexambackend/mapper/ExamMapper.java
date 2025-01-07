package com.sunhao.onlineexambackend.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 考试表 Mapper 接口
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface ExamMapper extends BaseMapper<Exam> {

    IPage<Exam> getExams(Page<Exam> examPage);

    Exam getExam(Integer id);
}
