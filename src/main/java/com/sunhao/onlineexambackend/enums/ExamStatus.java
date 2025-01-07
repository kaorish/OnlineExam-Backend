package com.sunhao.onlineexambackend.enums;

public enum ExamStatus {

    NOT_STARTED(0),
    ONGOING(1),
    FINISHED(2);

    private final int code;

    ExamStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ExamStatus fromCode(int code) {
        for (ExamStatus status : ExamStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ExamStatus code: " + code);
    }
}
