package com.example.MyWork.aop;

import com.alibaba.fastjson.JSON;
import com.example.MyWork.mapper.OperateLogMapper;
import com.example.MyWork.pojo.OperateLog;
import com.example.MyWork.tools.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: LogAspect
 * @Date: 2023/11/28
 * @Time: 11:23
 * @Description:添加自定义描述
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Around("@annotation(com.example.MyWork.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //解析请求头的JWT令牌
        String jwt = request.getHeader("token");

        //操作人id
        int id = Integer.parseInt(JwtUtil.getDataByKey(jwt, "id"));

        //操作的类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作的方法名
        String methodName = joinPoint.getSignature().getName();

        //操作的参数
        Object[] args = joinPoint.getArgs();
        String methodParms = Arrays.toString(args);

        //方法返回值
        Long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        String returnValue = JSON.toJSONString(result);
        Long end = System.currentTimeMillis();

        //操作耗时
        Long costTime = end - begin;

        //操作时间
        LocalDateTime now = LocalDateTime.now();

        //记录操作日志
        OperateLog operatelog = new OperateLog(null, id, now, className, methodName, methodParms, returnValue, costTime);

        log.info("AOP记录操作日志{}", operatelog);
        operateLogMapper.insert(operatelog);
        return result;
    }
}
