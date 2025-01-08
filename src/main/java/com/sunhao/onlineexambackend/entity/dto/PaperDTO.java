package com.sunhao.onlineexambackend.entity.dto;

import lombok.Data;

@Data
public class PaperDTO {

    private Integer paperId; // 试卷id
    private String title; // 试卷名称
    private Integer changeNumber; // 选择题数量
    private Integer fillNumber; // 填空题数量
    private Integer judgeNumber; // 判断题数量

}
