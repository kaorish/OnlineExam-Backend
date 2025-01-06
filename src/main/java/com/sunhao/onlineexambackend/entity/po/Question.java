package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 题库表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学科
     */
    private String subject;

    /**
     * 题目
     */
    private String title;

    /**
     * 选项A
     */
    private String optionA;

    /**
     * 选项B
     */
    private String optionB;

    /**
     * 选项C
     */
    private String optionC;

    /**
     * 选项D
     */
    private String optionD;

    /**
     * 答案
     */
    private String answer;

    /**
     * 分值
     */
    private Integer score;

    /**
     * 解析
     */
    private String analysis;

    /**
     * 题目类型(0选择，1填空，2判断)
     */
    private Integer type;

    /**
     * 难度(0简单，1中等，2困难)
     */
    private Integer difficulty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Question{" +
            "id = " + id +
            ", subject = " + subject +
            ", title = " + title +
            ", optionA = " + optionA +
            ", optionB = " + optionB +
            ", optionC = " + optionC +
            ", optionD = " + optionD +
            ", answer = " + answer +
            ", score = " + score +
            ", analysis = " + analysis +
            ", type = " + type +
            ", difficulty = " + difficulty +
        "}";
    }
}
