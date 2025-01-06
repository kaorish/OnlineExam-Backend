package com.sunhao.onlineexambackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunhao.onlineexambackend.mapper")
public class OnlineExamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineExamBackendApplication.class, args);
    }

}
