package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Reply;
import com.sunhao.onlineexambackend.service.serviceimpl.ReplyServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 回复表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
public class ReplyController {

    @Resource
    private ReplyServiceImpl replyService;

    /**
     * 分页查询所有回复
     * @param message_id
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/replies")
    public ResultUtil getReplies(@RequestParam(value = "message_id") String message_id,
                                 @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Reply> replyPage = new Page<>(page, size);
        IPage<Reply> res = replyService.getReplies(replyPage, message_id);
        if (res != null && res.getTotal() > 0) {
            return ResultUtil.isSuccess("查询成功", res);
        } else {
            return ResultUtil.isFail(404, "未查询到回复");
        }
    }

    /**
     * 添加回复
     * @param reply
     * @return
     */
    @PostMapping("/reply")
    public ResultUtil addReply(@RequestBody Reply reply) {
        boolean res = replyService.save(reply);
        if (res) {
            return ResultUtil.isSuccess("添加回复成功", null);
        } else {
            return ResultUtil.isFail(500, "添加回复失败");
        }
    }

    /**
     * 删除回复
     * @param id
     * @return
     */
    @DeleteMapping("/reply")
    public ResultUtil deleteReply(@RequestParam(value = "id") Integer id) {
        Reply reply = replyService.getById(id);
        if (reply == null) {
            return ResultUtil.isFail(404, "回复不存在");
        }
        boolean res = replyService.removeById(id);
        if (res) {
            return ResultUtil.isSuccess("删除回复成功", null);
        } else {
            return ResultUtil.isFail(500, "删除回复失败");
        }
    }

}
