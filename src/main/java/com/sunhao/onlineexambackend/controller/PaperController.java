package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.po.Paper;
import com.sunhao.onlineexambackend.service.serviceimpl.PaperServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * <p>
 * 试卷表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

    @Resource
    private PaperServiceImpl paperService;

    /**
     * 分页查询所有试卷
     * 示例请求: GET /papers?page=1&size=10
     *
     * @param page 当前页码
     * @param size 每页记录数
     * @return 分页结果
     */
    @GetMapping("/papers")
    public ResultUtil getPapers(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Paper> paperPage = new Page<>(page, size);
        IPage<Paper> res = paperService.getPapers(paperPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有试卷", res);
        } else {
            return ResultUtil.isFail(400, "查询失败");
        }

    }

}
