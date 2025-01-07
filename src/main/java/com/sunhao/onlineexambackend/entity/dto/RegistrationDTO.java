package com.sunhao.onlineexambackend.entity.dto;

import com.sunhao.onlineexambackend.entity.po.User;
import lombok.Data;

@Data
public class RegistrationDTO {

    private User user;

    private String verificationCode;
}
