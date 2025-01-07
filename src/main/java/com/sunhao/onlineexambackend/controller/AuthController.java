package com.sunhao.onlineexambackend.controller;

import com.sunhao.onlineexambackend.entity.dto.LoginDTO;
import com.sunhao.onlineexambackend.entity.dto.RegistrationDTO;
import com.sunhao.onlineexambackend.entity.dto.SendSmsRequestDTO;
import com.sunhao.onlineexambackend.entity.po.User;
import com.sunhao.onlineexambackend.service.serviceimpl.AuthServiceImpl;
import com.sunhao.onlineexambackend.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public ResultUtil login(@RequestBody LoginDTO loginDTO) {
        User res = authService.login(loginDTO);
        if (res != null) {
            return ResultUtil.isSuccess("登录成功", res);
        } else {
            return ResultUtil.isFail(400, "登录失败");
        }
    }

    @PostMapping("/register")
    public ResultUtil register(@RequestBody RegistrationDTO registrationDTO) {
        int res = authService.register(registrationDTO);
        if (res != 0) {
            return ResultUtil.isSuccess("注册成功", res);
        } else {
            return ResultUtil.isFail(400, "注册失败");
        }
    }

    @PostMapping("/sendSMS")
    public ResultUtil sendSms(@RequestBody SendSmsRequestDTO sendSmsRequestDTO) {
        boolean res = authService.sendSms(sendSmsRequestDTO.getTel());
        if (res) {
            return ResultUtil.isSuccess("发送成功", null);
        } else {
            return ResultUtil.isFail(400, "发送失败");
        }
    }
}
