package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Message;
import com.sunhao.onlineexambackend.service.serviceimpl.MessageServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 留言表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
public class MessageController {

    @Resource
    private MessageServiceImpl messageService;

    /**
     * 分页查询所有留言
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/messages/all")
    public ResultUtil getMessages(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Message> messagePage = new Page<>(page, size);
        IPage<Message> res = messageService.getMessages(messagePage);
        if (res != null && res.getTotal() > 0) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到留言");
        }
    }

    /**
     * 根据id查询留言
     * @param page
     * @param size
     * @param id 留言id
     * @return
     */
    @GetMapping("/messages/byId")
    public ResultUtil getMessagesById(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam("id") Integer id) {
        Page<Message> messagePage = new Page<>(page, size);
        IPage<Message> res = messageService.getMessagesById(messagePage, id);
        if (res != null) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到留言");
        }
    }

    /**
     * 添加留言
     * @param message 留言
     * @return
     */
    @PostMapping("/message")
    public ResultUtil add(@RequestBody Message message) {
        int res = messageService.addMessage(message);
        if (res == 0) {
            return ResultUtil.isFail(500, "添加失败");
        } else {
            return ResultUtil.isSuccess("添加成功", res);
        }
    }

    /**
     * 更新留言
     * @param message 留言
     * @return
     */
    @PutMapping("/message")
    public ResultUtil update(@RequestBody Message message) {
        boolean res = messageService.updateById(message);
        if (res) {
            return ResultUtil.isSuccess("更新成功", null);
        } else {
            return ResultUtil.isFail(500, "更新失败");
        }
    }


    /**
     * 删除留言
     * @param id 留言id
     * @return
     */
    @DeleteMapping("/message")
    public ResultUtil delete(@RequestParam("id") Integer id) {
        int res = messageService.deleteMessage(id);
        if (res == 0) {
            return ResultUtil.isFail(500, "删除失败");
        } else {
            return ResultUtil.isSuccess("删除成功", null);
        }
    }
}
