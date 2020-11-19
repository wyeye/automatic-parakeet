package com.wyeye.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.source.tree.Tree;
import com.wyeye.sys.entity.CfSysMenu;
import com.wyeye.sys.service.ICfSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * 菜单表 前端控制器
 *
 * @author wyeye
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/sys/cf-sys-menu")
public class CfSysMenuController {

  @Autowired private ICfSysMenuService cfSysMenuService;

  @GetMapping("findAll")
  public List getMenu() {
    QueryWrapper<CfSysMenu> wrapper = new QueryWrapper();
    wrapper.eq("REC_FLAG", 1).orderByAsc("PARENT_ID", "MENU_ORD");
    List<CfSysMenu> list = cfSysMenuService.list(wrapper);
    for (CfSysMenu cfSysMenu : list) {
      cfSysMenu.getMenuName();
    }
    return list;
  }
}
