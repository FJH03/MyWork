package com.example.MyWork.service.impl;

import com.example.MyWork.mapper.DeptLogMapper;
import com.example.MyWork.pojo.DeptLog;
import com.example.MyWork.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: DeptLogServiceImpl
 * @Date: 2023/11/27
 * @Time: 16:29
 * @Description:添加自定义描述
 */
@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
