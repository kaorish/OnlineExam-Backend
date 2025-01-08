package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.ExamWithStatusDTO;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.sunhao.onlineexambackend.enums.ExamStatus;
import com.sunhao.onlineexambackend.mapper.ExamMapper;
import com.sunhao.onlineexambackend.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private ExamMapper examMapper;

    @Override
    public IPage<Exam> getExams(Page<Exam> examPage) {
        return examMapper.getExams(examPage);
    }

    @Override
    public Exam getExam(Integer id) {
        return examMapper.getExam(id);
    }

    @Override
    public int addExam(Exam exam) {
        return examMapper.insert(exam);
    }

    @Override
    public int updateExam(Exam exam) {
        return examMapper.updateById(exam);
    }

    @Override
    public int deleteExam(Integer id) {
        return examMapper.deleteById(id);
    }

    @Override
    public IPage<ExamWithStatusDTO> getAllExamsWithStatus(int page, int size) {
        Page<Exam> examPage = new Page<>(page, size);
        IPage<Exam> res = examMapper.selectPage(examPage, null);
        IPage<ExamWithStatusDTO> dtoPage = new Page<>(page, size, res.getTotal());

        List<ExamWithStatusDTO> dtoList = res.getRecords().stream()
                .map(exam -> {
                    ExamWithStatusDTO dto = new ExamWithStatusDTO();
                    dto.setExam(exam);
                    return dto;
                })
                .collect(Collectors.toList());

        dtoPage.setRecords(dtoList);
        return dtoPage;
    }

    @Override
    public IPage<ExamWithStatusDTO> getExamsByStatus(ExamStatus status, int page, int size) {
        Page<Exam> examPage = new Page<>(page, size);
        // 根据状态过滤考试
        List<Exam> exams;
        LocalDateTime now = LocalDateTime.now();
        switch (status) {
            case NOT_STARTED:
                exams = examMapper.selectList(new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Exam>()
                        .gt("start_time", now));
                break;
            case ONGOING:
                exams = examMapper.selectList(new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Exam>()
                        .le("start_time", now)
                        .ge("end_time", now));
                break;
            case FINISHED:
                exams = examMapper.selectList(new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<Exam>()
                        .lt("end_time", now));
                break;
            default:
                throw new IllegalArgumentException("Invalid ExamStatus");
        }

        // 分页
        int total = exams.size();
        int fromIndex = (page - 1) * size;
        int toIndex = Math.min(fromIndex + size, total);
        if (fromIndex >= total) {
            exams = List.of();
        } else {
            exams = exams.subList(fromIndex, toIndex);
        }

        IPage<ExamWithStatusDTO> dtoPage = new Page<>(page, size, total);

        List<ExamWithStatusDTO> dtoList = exams.stream()
                .map(exam -> {
                    ExamWithStatusDTO dto = new ExamWithStatusDTO();
                    dto.setExam(exam);
                    return dto;
                })
                .collect(Collectors.toList());

        dtoPage.setRecords(dtoList);
        return dtoPage;
    }

    @Override
    public IPage<Exam> getExamsBySubject(String subject, Page<Exam> examPage) {

        QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();

        // 将输入的 subject 分解成多个关键词
        String[] keywords = subject.split("");  // 这里简单地按照每个字符分开，可以根据需求调整分割方式

        // 为每个关键词添加 LIKE 查询条件
        for (String keyword : keywords)
            queryWrapper.like("subject", keyword);  // 添加 LIKE 查询条件
        return examMapper.selectPage(examPage, queryWrapper);  // 调用 BaseMapper 提供的 selectPage 方法
    }

}
