package com.itheima.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */
@Component
public class AliOSSUtils {

    // @Value注解只能一个一个的进行外部属性的注入。
    // @ConfigurationProperties可以批量的将外部的属性配置注入到bean对象的属性中。(推荐)

//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;


    /**
     * 实现上传图片到OSS
     */
//    public String upload(MultipartFile file) throws IOException {
//        // 获取上传的文件的输入流
//        InputStream inputStream = file.getInputStream();
//
//        // 避免文件覆盖
//        String originalFilename = file.getOriginalFilename();
//        // 构建新的文件名
//        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        // 上传文件到 OSS
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//        ossClient.putObject(bucketName, fileName, inputStream);
//
//        // 拼接文件访问路径。eg：https://xzy-web-tlias.oss-cn-beijing.aliyuncs.com/1.jpg
//        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
//
//        // 关闭ossClient
//        ossClient.shutdown();
//
//        // 把上传到oss的路径返回
//        return url;
//    }


    //注入配置参数实体类对象
    @Resource
    private AliOSSProperties aliOSSProperties;


    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile multipartFile) throws IOException {
        // 获取上传的文件的输入流
        InputStream inputStream = multipartFile.getInputStream();

        // 避免文件覆盖
        String originalFilename = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(aliOSSProperties.getEndpoint(),
                aliOSSProperties.getAccessKeyId(), aliOSSProperties.getAccessKeySecret());
        ossClient.putObject(aliOSSProperties.getBucketName(), fileName, inputStream);

        // 文件访问路径
        String url =aliOSSProperties.getEndpoint().split("//")[0] + "//" + aliOSSProperties.getBucketName() + "." + aliOSSProperties.getEndpoint().split("//")[1] + "/" + fileName;

        // 关闭ossClient
        ossClient.shutdown();

        // 把上传到oss的路径返回
        return url;
    }

}
