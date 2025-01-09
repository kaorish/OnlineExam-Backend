package com.sunhao.onlineexambackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunhao.onlineexambackend.entity.dto.PaperDTO;
import com.sunhao.onlineexambackend.entity.po.Paper;
import com.sunhao.onlineexambackend.service.serviceimpl.PaperServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 试卷表 前端控制器
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
@RestController
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
            return ResultUtil.isFail(404, "未查询到试卷");
        }
    }

    @GetMapping("/papers/byExamId")
    public ResultUtil getPapersByExamId(
            @RequestParam(value = "exam_id") Integer exam_id,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<Paper> paperPage = new Page<>(page, size);
        IPage<Paper> res = paperService.getPapersByExamId(exam_id, paperPage);
        if (res != null) {
            return ResultUtil.isSuccess("分页查询所有试卷", res);
        } else {
            return ResultUtil.isFail(404, "未查询到试卷");
        }
    }

    /**
     * 根据试卷ID查询试卷
     * 示例请求: GET /paper?id=1
     *
     * @param id 试卷ID
     * @return 试卷信息
     */
    @GetMapping("/paper")
    public ResultUtil getPaperById(@RequestParam("id") Integer id) {
        Paper res = paperService.getPaperById(id);
        if (res != null) {
            return ResultUtil.isSuccess("根据ID查询试卷", res);
        } else {
            return ResultUtil.isFail(404, "未查询到试卷");
        }
    }

    /**
     * 添加试卷
     * 示例请求: POST /paper/auto
     * @param paperDTO 组卷信息
     * @return 添加结果
     */
    @PostMapping("/paper/auto")
    public ResultUtil addPaperAuto(@RequestBody PaperDTO paperDTO) {

        boolean res = paperService.addPaperAuto(paperDTO);

        if (res) {
            return ResultUtil.isSuccess("自动组卷成功", null);
        } else {
            return ResultUtil.isFail(500, "自动组卷失败");
        }
    }

    @PutMapping("/paper")
    public ResultUtil updatePaper(@RequestBody Paper paper) {
        boolean res = paperService.updateById(paper);
        if (res) {
            return ResultUtil.isSuccess("更新成功", paper);
        } else {
            return ResultUtil.isFail(500, "更新失败");
        }
    }

    /**
     * 删除试卷
     * 示例请求: DELETE /paper?id=1
     * @param id 试卷ID
     * @return 删除结果
     */
    @DeleteMapping("/paper")
    public ResultUtil deletePaper(@RequestParam("id") Integer id) {
        int res = paperService.deletePaper(id);
        if (res == 1) {
            return ResultUtil.isSuccess("删除成功", res);
        } else {
            return ResultUtil.isFail(500, "删除失败");
        }
    }
}
