package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.ExamWithStatusDTO;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunhao.onlineexambackend.enums.ExamStatus;

import java.util.List;

/**
 * <p>
 * 考试表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IExamService extends IService<Exam> {

    IPage<Exam> getExams(Page<Exam> examPage);

    Exam getExam(Integer id);

    int addExam(Exam exam);

    int updateExam(Exam exam);

    int deleteExam(Integer id);

    /**
     * 分页查询所有考试及其状态
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    IPage<ExamWithStatusDTO> getAllExamsWithStatus(int page, int size);

    /**
     * 分页根据状态查询考试
     *
     * @param status 状态码（0未开始，1进行中，2已结束）
     * @param page   当前页码
     * @param size   每页记录数
     * @return 分页结果
     */
    IPage<ExamWithStatusDTO> getExamsByStatus(ExamStatus status, int page, int size);
}
