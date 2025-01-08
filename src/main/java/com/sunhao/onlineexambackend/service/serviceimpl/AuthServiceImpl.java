package com.sunhao.onlineexambackend.service.serviceimpl;

import com.sunhao.onlineexambackend.entity.dto.LoginDTO;
import com.sunhao.onlineexambackend.entity.dto.RegistrationDTO;
import com.sunhao.onlineexambackend.entity.po.User;
import com.sunhao.onlineexambackend.mapper.UserMapper;
import com.sunhao.onlineexambackend.service.AuthService;
import com.sunhao.onlineexambackend.util.HashPasswordWithSalt;
import com.sunhao.onlineexambackend.util.HttpUtils;
import com.sunhao.onlineexambackend.util.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private HttpSession httpSession;

    @Override
    public User login(LoginDTO loginDTO) {
        String password = loginDTO.getPassword(); // 用户输入的密码
        System.out.println("password: " + password);
        User user = userMapper.selectById(loginDTO.getId()); // 取出的用户对象
        String salt = user.getSalt(); // 用户的盐
        System.out.println("salt: " + salt);
        String pwdHash = HashPasswordWithSalt.hashPasswordWithSalt(password, salt); // 生成的密码哈希值
        System.out.println("pwdHash: " + pwdHash);
        if (pwdHash.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public int register(RegistrationDTO registrationDTO) {
        User user = registrationDTO.getUser();
        String verificationCode = registrationDTO.getVerificationCode();
        if (!verificationCode.equals(httpSession.getAttribute("verificationCode"))) {
            return 0;
        }
        String salt = SaltGenerator.generateSalt();
        String password = HashPasswordWithSalt.hashPasswordWithSalt(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(password);
        return userMapper.addStudent(user);
    }

    @Override
    public boolean sendSms(String phone) {
        // 验证码
        String variables = generateVerificationCode();
        httpSession.setAttribute("verificationCode", variables);
        System.out.println("验证码：" + variables);
        // 验证码模版id
        String templateId = "CST_ptdie100";

        boolean success = false;

        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "f73cdd6604394778862c75dcc60d075a";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:" + variables);
        bodys.put("template_id", templateId);  //注意，CST_ptdie100该模板ID仅为调试使用，调试结果为"status": "OK" ，即表示接口调用成功，然后联系客服报备自己的专属签名模板ID，以保证短信稳定下发
        bodys.put("phone_number", phone);


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            org.apache.http.HttpResponse  response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
//            System.out.println(EntityUtils.toString(response.getEntity()));
            if (response.toString().contains("OK")) success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // 生成 6 位随机验证码
    private String generateVerificationCode() {
        String str = "0123456789";
        String code = "";
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * str.length());
            code += str.charAt(index);
        }
        return code;
    }
}
