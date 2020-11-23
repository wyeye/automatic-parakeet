package com.wyeye.oss.controller;

import com.wyeye.commonutil.R;
import com.wyeye.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/23 10:20 上午
 */
@RestController
@RequestMapping("/oss/fileOss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R uploadOssFile(MultipartFile file) {
        String pathUrl = ossService.uploadOssFile(file);
        return R.ok().data("pathUrl", pathUrl);
    }
}
