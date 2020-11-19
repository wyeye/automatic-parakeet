package com.wyeye.cfsys.service;

import com.wyeye.cfsys.entity.CfSysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菜单表 服务类
 *
 * @author wyeye
 * @since 2020-11-18
 */
public interface ICfSysMenuService extends IService<CfSysMenu> {

    CfSysMenu getMenu();

    void updateMenu();
}
