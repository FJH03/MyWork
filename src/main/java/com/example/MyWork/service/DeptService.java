package com.example.MyWork.service;

import com.example.MyWork.pojo.Dept;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: DeptService
 * @Date: 2023/11/21
 * @Time: 18:19
 * @Description:添加自定义描述
 */
public interface DeptService {
    List<Dept> list();

    void deleteByid(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept getById(Integer id);
}
