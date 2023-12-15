package com.example.MyWork.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: Result
 * @Date: 2023/11/21
 * @Time: 18:24
 * @Description:添加自定义描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//1 成功 , 0 失败
    private String msg; //提示信息
    private Object data; //数据 data

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result success() {
        return new Result(1, "success", null);
    }

    public static Result error(String msg) {
        return new Result(0, msg, null);
    }
}
