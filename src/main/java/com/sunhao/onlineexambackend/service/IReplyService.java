package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 回复表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IReplyService extends IService<Reply> {

    IPage<Reply> getReplies(Page<Reply> replyPage, String messageId);
}
