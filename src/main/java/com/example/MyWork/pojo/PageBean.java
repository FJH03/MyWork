package com.example.MyWork.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: PageBean
 * @Date: 2023/11/22
 * @Time: 14:57
 * @Description:添加自定义描述
 */

@Data
@AllArgsConstructor
public class PageBean {
    private Long total;
    private List rows;
}
