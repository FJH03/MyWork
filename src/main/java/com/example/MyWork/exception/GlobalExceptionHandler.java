package com.example.MyWork.exception;

import com.example.MyWork.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: GlobalExceptionHandler
 * @Date: 2023/11/27
 * @Time: 15:10
 * @Description:添加自定义描述
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员。");
    }

}
