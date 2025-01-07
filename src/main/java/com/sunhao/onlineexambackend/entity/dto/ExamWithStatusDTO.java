package com.sunhao.onlineexambackend.entity.dto;

import com.sunhao.onlineexambackend.entity.po.Exam;
import com.sunhao.onlineexambackend.enums.ExamStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExamWithStatusDTO {
    private Exam exam;
    private ExamStatus status;

    public ExamStatus getStatus() {
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(exam.getStartTime())) {
            return ExamStatus.NOT_STARTED;
        } else if (now.isAfter(exam.getEndTime())) {
            return ExamStatus.FINISHED;
        } else {
            return ExamStatus.ONGOING;
        }
    }

}
