package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.PaperDTO;
import com.sunhao.onlineexambackend.entity.po.Exam;
import com.sunhao.onlineexambackend.entity.po.Paper;
import com.sunhao.onlineexambackend.entity.po.PaperQuestion;
import com.sunhao.onlineexambackend.entity.po.Question;
import com.sunhao.onlineexambackend.mapper.ExamMapper;
import com.sunhao.onlineexambackend.mapper.PaperMapper;
import com.sunhao.onlineexambackend.mapper.PaperQuestionMapper;
import com.sunhao.onlineexambackend.mapper.QuestionMapper;
import com.sunhao.onlineexambackend.service.IPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 试卷表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements IPaperService {

    @Resource
    private PaperMapper paperMapper;

    @Resource
    private ExamMapper examMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public IPage<Paper> getPapers(Page<Paper> paperPage) {
        return paperMapper.selectPage(paperPage, null);
    }

    @Override
    public Paper getPaperById(Integer id) {
        return paperMapper.selectById(id);
    }

    @Override
    public int addPaper(Paper paper) {
        return paperMapper.insert(paper);
    }

    @Override
    public int deletePaper(Integer id) {
        return paperMapper.deleteById(id);
    }

    @Override
    public IPage<Paper> getPapersByExamId(Integer exam_id, Page<Paper> paperPage) {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("exam_id", exam_id);
        return paperMapper.selectPage(paperPage, queryWrapper);
    }

    @Override
    public boolean addPaperAuto(PaperDTO paperDTO) {
        Paper paper = new Paper();
        paper.setTitle(paperDTO.getTitle());
        Exam exam = examMapper.getExamByTitle(paperDTO.getExam_title()); // 根据试卷的title找到对应的考试
        if (exam == null) {
            return false;
        }
        paper.setExamId(exam.getId());
        String subject = exam.getSubject();
        paperMapper.insert(paper); // 插入新试卷的对应关系

        Integer paperId = paper.getId(); // 取出刚刚插入的试卷的id，自动生成的，因为是引用所以可以这样拿
        Integer changeNumber = paperDTO.getChangeNumber();
        Integer fillNumber = paperDTO.getFillNumber();
        Integer judgeNumber = paperDTO.getJudgeNumber();

        List<Question> Multiple = questionMapper.getQuestionsByTypeAndSubject(subject, 0); // 选择题
        List<Question> Fill = questionMapper.getQuestionsByTypeAndSubject(subject, 1); // 填空题
        List<Question> Judge = questionMapper.getQuestionsByTypeAndSubject(subject, 2); // 判断题

        PaperQuestion paperQuestion = new PaperQuestion();
        paperQuestion.setPaperId(paperId);
        // 把题目的id插入到paper_question表中，每种题型的题目数量由前端传入，随机选取
        // 选择题
        for (int i = 0; i < changeNumber; i++) {
            int index = (int) (Math.random() * Multiple.size());
            paperQuestion.setQuestionId(Multiple.get(index).getId());
            paperQuestionMapper.insert(paperQuestion);
        }

        // 填空题
        for (int i = 0; i < fillNumber; i++) {
            int index = (int) (Math.random() * Fill.size());
            paperQuestion.setQuestionId(Fill.get(index).getId());
            paperQuestionMapper.insert(paperQuestion);
        }

        // 判断题
        for (int i = 0; i < judgeNumber; i++) {
            int index = (int) (Math.random() * Judge.size());
            paperQuestion.setQuestionId(Judge.get(index).getId());
            paperQuestionMapper.insert(paperQuestion);
        }

        return true;
    }
}
