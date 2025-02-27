package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 考试表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考试编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 考试名称
     */
    private String title;

    /**
     * 学科
     */
    private String subject;

    /**
     * 选用试卷编号
     */
    @TableField("paper_id")
    @JsonProperty("paper_Id")
    private Integer paperId;

    /**
     * 学院
     */
    private String institute;

    /**
     * 专业
     */
    private String major;

    /**
     * 年级
     */
    private String grade;

    /**
     * 学期
     */
    private String term;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 考试时长
     */
    private Integer duration;

    /**
     * 总分
     */
    private Integer totalScore;


    /**
     * 考试类型
     */
    private String type;

    /**
     * 注意事项
     */
    private String tips;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "Exam{" +
            "id = " + id +
            ", title = " + title +
            ", subject = " + subject +
            ", paperId = " + paperId +
            ", institute = " + institute +
            ", major = " + major +
            ", grade = " + grade +
            ", term = " + term +
            ", startTime = " + startTime +
            ", endTime = " + endTime +
            ", duration = " + duration +
            ", totalScore = " + totalScore +
            ", type = " + type +
            ", tips = " + tips +
        "}";
    }
}
