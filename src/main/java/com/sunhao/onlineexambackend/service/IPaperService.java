package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 试卷表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IPaperService extends IService<Paper> {

    IPage<Paper> getPapers(Page<Paper> paperPage);
}
