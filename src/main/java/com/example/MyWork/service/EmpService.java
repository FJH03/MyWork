package com.example.MyWork.service;

import com.example.MyWork.pojo.Emp;
import com.example.MyWork.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: EmpServiceImpl
 * @Date: 2023/11/21
 * @Time: 18:19
 * @Description:添加自定义描述
 */
public interface EmpService {
    PageBean query(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    void update(Emp emp);

    Emp getById(Integer id);

    Emp login(Emp emp);
}
