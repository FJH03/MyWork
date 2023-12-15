package com.example.MyWork.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: DeptLog
 * @Date: 2023/11/27
 * @Time: 16:26
 * @Description:添加自定义描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private LocalDateTime createTime;
    private String description;
}
