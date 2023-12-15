package com.example.MyWork.controller;

import com.example.MyWork.pojo.Emp;
import com.example.MyWork.pojo.Result;
import com.example.MyWork.service.EmpService;
import com.example.MyWork.tools.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: LoginController
 * @Date: 2023/11/26
 * @Time: 16:06
 * @Description:添加自定义描述
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录{}", emp);
        Emp e = empService.login(emp);
        if (e != null) {
            Map<String, String> map = new HashMap<>();
            map.put("id", String.valueOf(e.getId()));
            map.put("name", e.getName());
            map.put("username", e.getUsername());

            String str = JwtUtil.getToken(map);
            return Result.success(str);
        } else {
            return Result.error("用户名或密码错误！");
        }
    }
}
