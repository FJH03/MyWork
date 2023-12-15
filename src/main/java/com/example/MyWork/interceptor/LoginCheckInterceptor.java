package com.example.MyWork.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.MyWork.pojo.Result;
import com.example.MyWork.tools.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: LoginCheckInterceptor
 * @Date: 2023/11/27
 * @Time: 13:48
 * @Description:添加自定义描述
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源方法运行前运行，返回true：放行， 返回false：拦截
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String url = req.getRequestURI();
        log.info("请求的URL:{}", url);

        String jwt = req.getHeader("token");

        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        String id = JwtUtil.getDataByKey(jwt, "id");
        String username = JwtUtil.getDataByKey(jwt, "username");
        String name = JwtUtil.getDataByKey(jwt, "name");
        log.info("id:{}, username:{}, name:{}", id, username, name);

        if (id != null && username != null && name != null) {
            log.info("令牌合法");
            return true;
        } else {
            log.info("解析令牌失败");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notlogin);
            return false;
        }
    }
}
