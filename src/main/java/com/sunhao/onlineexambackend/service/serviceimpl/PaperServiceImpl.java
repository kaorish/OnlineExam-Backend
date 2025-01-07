package com.sunhao.onlineexambackend.service.serviceimpl;

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
}
