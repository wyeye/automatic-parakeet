package com.wyeye.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.PutObjectResult;
import com.wyeye.oss.service.OssService;
import com.wyeye.oss.util.ConstantPropertiesUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/23 10:21 上午
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadOssFile(MultipartFile file) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ConstantPropertiesUtils.END_POINT, ConstantPropertiesUtils.ACCESS_KEY_ID, ConstantPropertiesUtils.ACCESS_KEY_SECRET);
        String path = new DateTime().toString("yyyy/MM/dd") + "/" + UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename();
        try {
            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ConstantPropertiesUtils.BUCKET_NAME, path, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }

        return "https://" + ConstantPropertiesUtils.BUCKET_NAME + "." + ConstantPropertiesUtils.END_POINT + "/" + path;
    }
}
