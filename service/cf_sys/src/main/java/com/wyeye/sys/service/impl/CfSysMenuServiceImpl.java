package com.wyeye.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyeye.sys.entity.CfSysMenu;
import com.wyeye.sys.mapper.CfSysMenuMapper;
import com.wyeye.sys.service.ICfSysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单表 服务实现类
 *
 * @author wyeye
 * @since 2020-11-18
 */
@Service
public class CfSysMenuServiceImpl extends ServiceImpl<CfSysMenuMapper, CfSysMenu>
    implements ICfSysMenuService {
  @Autowired private RedisTemplate<String, String> redisTemplate;

  @Override
  public void updateMenu() {
    QueryWrapper<CfSysMenu> wrapper = new QueryWrapper();
    wrapper.eq("REC_FLAG", 1).orderByAsc("PARENT_ID", "MENU_ORD");
    List<CfSysMenu> cfSysMenus = baseMapper.selectList(wrapper);
    CfSysMenu root = cfSysMenus.get(0);
    setRoot(root, cfSysMenus.subList(1, cfSysMenus.size()));
    redisTemplate.opsForValue().set("cf:sys:menu", JSON.toJSONString(root));
  }

  private void setRoot(CfSysMenu root, List<CfSysMenu> cfSysMenus) {
    for (int i = 0; i < cfSysMenus.size(); ) {
      CfSysMenu child = cfSysMenus.get(i);
      if (root.getId().equals(child.getParentId())) {
        if (root.getCfSysMenuList() == null) {
          root.setCfSysMenuList(new ArrayList<>());
        }
        root.getCfSysMenuList().add(child);
        cfSysMenus.remove(i);
        continue;
      }
      i++;
    }
    if (root.getCfSysMenuList() != null)
      root.getCfSysMenuList().forEach(child -> setRoot(child, cfSysMenus));
  }
}
