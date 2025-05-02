package com.sunhao.onlineexambackend.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Message;
import com.sunhao.onlineexambackend.entity.po.Reply;
import com.sunhao.onlineexambackend.mapper.MessageMapper;
import com.sunhao.onlineexambackend.mapper.ReplyMapper;
import com.sunhao.onlineexambackend.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 留言表 服务实现类
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private ReplyMapper replyMapper;


    @Override
    public IPage<Message> getMessages(Page<Message> messagePage) {
        return messageMapper.selectPage(messagePage, null);
    }

    @Override
    public IPage<Message> getMessagesById(Page<Message> messagePage, Integer id) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return messageMapper.selectPage(messagePage, queryWrapper);
    }

    @Override
    public int addMessage(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int deleteMessage(Integer id) {
        // 先删除该留言下的回复，通过message_id删除
        QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("message_id", id);
        replyMapper.delete(queryWrapper);
        // 删除留言
        return messageMapper.deleteById(id);
    }
}
