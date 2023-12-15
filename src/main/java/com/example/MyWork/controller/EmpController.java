package com.example.MyWork.controller;

import com.example.MyWork.anno.Log;
import com.example.MyWork.pojo.Emp;
import com.example.MyWork.pojo.PageBean;
import com.example.MyWork.pojo.Result;
import com.example.MyWork.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: EmpController
 * @Date: 2023/11/21
 * @Time: 18:17
 * @Description:添加自定义描述
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result query(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name,
                        Short gender,
                        @DateTimeFormat(pattern = "YYYY-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "YYYY-MM-dd") LocalDate end) {
        log.info("分页查询， 参数{}，{}，{}，{}，{}，{}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.query(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("所删除的编号" + ids);
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("所添加的员工信息{}", emp);
        empService.add(emp);
        return Result.success();
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("所更新的emp实体{}", emp);
        empService.update(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("要查询的id" + id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

}
