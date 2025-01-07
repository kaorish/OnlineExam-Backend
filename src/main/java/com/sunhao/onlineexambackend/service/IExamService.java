package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
