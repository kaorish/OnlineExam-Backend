package com.sunhao.onlineexambackend.service;

import com.sunhao.onlineexambackend.entity.dto.LoginDTO;
import com.sunhao.onlineexambackend.entity.dto.RegistrationDTO;
import com.sunhao.onlineexambackend.entity.po.User;


public interface AuthService {
    User login(LoginDTO loginDTO);

    int register(RegistrationDTO registrationDTO);

    boolean sendSms(String phone);
}
