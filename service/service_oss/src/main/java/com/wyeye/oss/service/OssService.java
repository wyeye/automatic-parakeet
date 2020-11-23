package com.wyeye.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/23 10:19 上午
 */
public interface OssService {
    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    String uploadOssFile(MultipartFile file);
}
