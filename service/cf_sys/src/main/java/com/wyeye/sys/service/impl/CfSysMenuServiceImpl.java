package com.wyeye.sys.service.impl;

import com.wyeye.sys.entity.CfSysMenu;
import com.wyeye.sys.mapper.CfSysMenuMapper;
import com.wyeye.sys.service.ICfSysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public CfSysMenu getMenu() {
        return null;
    }
}
