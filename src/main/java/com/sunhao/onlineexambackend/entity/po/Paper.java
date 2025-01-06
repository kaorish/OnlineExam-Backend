package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
     * 题目编号
     */
    private String questionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Paper{" +
            "id = " + id +
            ", questionId = " + questionId +
        "}";
    }
}
