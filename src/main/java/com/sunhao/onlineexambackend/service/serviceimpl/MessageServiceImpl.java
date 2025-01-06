package com.sunhao.onlineexambackend.service.serviceimpl;

import com.sunhao.onlineexambackend.entity.po.Message;
import com.sunhao.onlineexambackend.mapper.MessageMapper;
import com.sunhao.onlineexambackend.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
