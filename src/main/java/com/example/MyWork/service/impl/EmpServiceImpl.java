package com.example.MyWork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.MyWork.mapper.EmpMapper;
import com.example.MyWork.pojo.Emp;
import com.example.MyWork.pojo.PageBean;
import com.example.MyWork.service.EmpService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: EmpServiceImpl
 * @Date: 2023/11/21
 * @Time: 18:19
 * @Description:添加自定义描述
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean query(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        Long count = empMapper.queryTotle();
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.query(start, pageSize, name, gender, begin, end);
        //封装对象
        PageBean pageBean = new PageBean(count, rows);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteBatchIds(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public Emp login(Emp emp) {
        LambdaQueryWrapper empLambdaQueryWrapper = new LambdaQueryWrapper<Emp>()
                .eq(Emp::getUsername, emp.getUsername()).eq(Emp::getPassword, emp.getPassword());
        return empMapper.selectOne(empLambdaQueryWrapper);
    }
}
