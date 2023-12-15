package com.example.MyWork.controller;

import com.example.MyWork.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: UploadController
 * @Date: 2023/11/23
 * @Time: 19:21
 * @Description:添加自定义描述
 */
@RestController
@Slf4j
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("上传文件{}, {}, {}",username, age, image);

        String name = image.getOriginalFilename();

        //构造唯一的文件名(uuid--通用唯一识别码)


        //将文件存储在服务器的磁盘目录中
        image.transferTo(new File("E:/project/day10/upload/" + name));
        return Result.success();
    }

}
