package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Paper;
import com.sunhao.onlineexambackend.mapper.PaperMapper;
import com.sunhao.onlineexambackend.service.IPaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
//        return paperMapper.getPapersByExamId(exam_id, paperPage);
    }
}
