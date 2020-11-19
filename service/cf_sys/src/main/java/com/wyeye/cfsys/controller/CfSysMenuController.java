package com.wyeye.cfsys.controller;

import com.wyeye.cfsys.service.ICfSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单表 前端控制器
 *
 * @author wyeye
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/sys/cf-sys-menu")
public class CfSysMenuController {

    @Autowired
    private ICfSysMenuService cfSysMenuService;


    @DeleteMapping("/delete/{id}")
    public boolean removeMenu(@PathVariable Long id) {
        boolean result = cfSysMenuService.removeById(id);
        return result;
    }
}
