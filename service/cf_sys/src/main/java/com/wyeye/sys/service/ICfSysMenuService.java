package com.wyeye.sys.service;

import com.wyeye.sys.entity.CfSysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 菜单表 服务类
 *
 * @author wyeye
 * @since 2020-11-18
 */
public interface ICfSysMenuService extends IService<CfSysMenu> {

    CfSysMenu getMenu();
}
