package com.example.MyWork.controller;

import com.example.MyWork.anno.Log;
import com.example.MyWork.pojo.Dept;
import com.example.MyWork.pojo.Result;
import com.example.MyWork.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: DeptController
 * @Date: 2023/11/21
 * @Time: 18:17
 * @Description:添加自定义描述
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    //查询部门信息
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    //根据id删除部门
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除" + id);
        deptService.deleteByid(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门{}", dept);
        deptService.add(dept);
        return Result.success(dept.getId());
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("获取部门id{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

}
