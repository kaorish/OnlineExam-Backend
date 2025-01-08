package com.sunhao.onlineexambackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Message;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 留言表 服务类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public interface IMessageService extends IService<Message> {


    IPage<Message> getMessages(Page<Message> messagePage);

    IPage<Message> getMessagesById(Page<Message> messagePage, Integer id);

    int addMessage(Message message);

    int deleteMessage(Integer id);
}
