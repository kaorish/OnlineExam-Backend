package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成绩编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 考试编号
     */
    private Integer examId;

    /**
     * 学工号
     */
    private Integer userId;

    /**
     * 学科
     */
    private String subject;

    /**
     * 分数
     */
    private Integer score;

    /**
     * 考试时间
     */
    private LocalDateTime date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Score{" +
            "id = " + id +
            ", examId = " + examId +
            ", userId = " + userId +
            ", subject = " + subject +
            ", score = " + score +
            ", date = " + date +
        "}";
    }
}
