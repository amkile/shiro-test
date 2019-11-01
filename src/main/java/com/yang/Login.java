package com.yang;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ygl
 * @description
 * @date 2019/11/01
 */
@Controller
public class Login {

    //http://localhost:8080/shiro_test_war/login?username=132&password=123
    @RequestMapping("login")
    @ResponseBody
    public String login(String  username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        return subject.isAuthenticated()+",";
    }

}
