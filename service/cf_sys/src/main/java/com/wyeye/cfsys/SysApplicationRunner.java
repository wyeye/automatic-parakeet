package com.wyeye.cfsys;

import com.wyeye.cfsys.service.ICfSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/*
 * 项目启动初始化
 * */
@Component
public class SysApplicationRunner implements ApplicationRunner {
    @Autowired
    private ICfSysMenuService cfSysMenuService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 初始化菜单
        cfSysMenuService.updateMenu();
    }
}
