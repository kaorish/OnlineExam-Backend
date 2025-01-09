package com.sunhao.onlineexambackend.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 回复表
 * </p>
 *
 * @author sunhao
 * @since 2025-01-06
 */
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复编号
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
     * 留言编号
     */
    @TableField("message_id")
    @JsonProperty("message_id")
    private Integer messageId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复时间
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

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
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
        return "Reply{" +
            "id = " + id +
            ", userId = " + userId +
            ", messageId = " + messageId +
            ", content = " + content +
            ", date = " + date +
        "}";
    }
}
