package com.itheima.controller;

import com.itheima.utils.AliOSSUtils;
import com.itheima.pojo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController
@Api(tags = "文件上传相关接口")
public class UploadController {

    /*
    @PostMapping("/upload")
    @ApiOperation("文件上传本地存储")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{},{},{}", username, age, image);
        // 获取原始文件的名称
        String originalFilename = image.getOriginalFilename();

        // 将文件存储在服务器的磁盘目录中(注意：这个路径必须已经存在)
        *//*image.transferTo(new File("D:\\images\\" + originalFilename));*//*

        // 构建新的文件名
        String extname = originalFilename.substring(originalFilename.lastIndexOf(".")); //文件扩展名
        String newFileName = UUID.randomUUID().toString() + extname;    //随机名 + 扩展名
        image.transferTo(new File("D:\\images\\" + newFileName));

        return Result.success();
    }*/

    @Resource
    private AliOSSUtils aliOSSUtilsl;

    /**
     * 文件上传阿里云OSS存储
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传阿里云OSS存储")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名：{}", image);
        // 获取原始文件的名称
        String originalFilename = image.getOriginalFilename();

        // 调用AliOSSUtils工具类
        String url = aliOSSUtilsl.upload(image);
        log.info("文件上传完成，文件访问的url：{}", url);
        return Result.success(url);
    }

}