package com.example.MyWork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.MyWork.mapper.DeptMapper;
import com.example.MyWork.mapper.EmpMapper;
import com.example.MyWork.pojo.Dept;
import com.example.MyWork.pojo.DeptLog;
import com.example.MyWork.service.DeptLogService;
import com.example.MyWork.service.DeptService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: DeptServiceImpl
 * @Date: 2023/11/21
 * @Time: 18:19
 * @Description:添加自定义描述
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<Dept>();
        return deptMapper.selectList(deptQueryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByid(Integer id) {
        try {
            //根据id删除部门
            deptMapper.deleteById(id);

            //根据部门id删除员工
            empMapper.deleteById(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散操作，此次解散的是" + id + "号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        LambdaQueryWrapper deptLambdaQueryWrapper = new LambdaQueryWrapper<Dept>().eq(Dept::getId, dept.getId());
        deptMapper.update(dept, deptLambdaQueryWrapper);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.selectById(id);
    }
}
