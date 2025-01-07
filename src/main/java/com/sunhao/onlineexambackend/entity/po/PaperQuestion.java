package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

@TableName("paper_question")
public class PaperQuestion {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("paper_id")
    @JsonProperty("paper_id")
    private Integer paperId;

    @TableField("question_id")
    @JsonProperty("question_id")
    private Integer questionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "PaperQuestion{" +
                "id=" + id +
                ", paperId=" + paperId +
                ", questionId=" + questionId +
                '}';
    }
}
