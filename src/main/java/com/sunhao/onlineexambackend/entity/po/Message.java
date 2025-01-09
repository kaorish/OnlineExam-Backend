package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 留言表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 留言编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学工号
     */
    @TableField("user_id")
    @JsonProperty("user_id")
    private String userId;

    /**
     * 留言标题
     */
    private String title;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 留言时间
     */
    private LocalDateTime date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
            "id = " + id +
            ", userId = " + userId +
            ", title = " + title +
            ", content = " + content +
            ", date = " + date +
        "}";
    }
}
