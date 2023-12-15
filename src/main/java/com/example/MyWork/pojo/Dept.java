package com.example.MyWork.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: Dept
 * @Date: 2023/11/21
 * @Time: 18:20
 * @Description:添加自定义描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id; //ID
    private String name; //部门名称
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
