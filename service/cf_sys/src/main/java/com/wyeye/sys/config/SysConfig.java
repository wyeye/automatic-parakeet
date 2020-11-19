package com.wyeye.sys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wyeye.sys.mapper")
public class SysConfig {
}
