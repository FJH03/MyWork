package com.example.MyWork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.MyWork.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
  * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
  * @Author: 2113042621-冯佳和
  * @ClassName: EmpMapper
  * @Date: 2023/11/21
  * @Time: 18:17
  * @Description:添加自定义描述
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    @Select("select count(1) from emp")
    Long queryTotle();
    List<Emp> query(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void update(Emp emp);
}
