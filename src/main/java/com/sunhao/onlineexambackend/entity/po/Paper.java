package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * <p>
 * 试卷表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 试卷名称
     */
    private String title;

    /**
     * 考试编号
     */
    @TableField("exam_id")
    @JsonProperty("exam_id") // 确保JSON中的exam_id映射到examId字段
    private Integer examId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", examId='" + examId + '\'' +
                '}';
    }
}
