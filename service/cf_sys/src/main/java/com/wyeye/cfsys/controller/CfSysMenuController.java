package com.wyeye.cfsys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyeye.cfsys.entity.CfSysMenu;
import com.wyeye.cfsys.entity.vo.CfSysMenuQuery;
import com.wyeye.cfsys.service.ICfSysMenuService;
import com.wyeye.commonutil.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单表 前端控制器
 *
 * @author wyeye
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/sys/cf-sys-menu")
@CrossOrigin
public class CfSysMenuController {

    @Autowired
    private ICfSysMenuService cfSysMenuService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @DeleteMapping("/delete/{id}")
    public boolean removeMenu(@PathVariable Long id) {
        boolean result = cfSysMenuService.removeById(id);
        return result;
    }

    @PostMapping("/pageMenu/{current}/{limit}")
    public R pageMenu(@PathVariable Long current, @PathVariable Long limit, @RequestBody(required = false) CfSysMenuQuery cfSysMenuQuery) {
        //创建配置对象
        Page<CfSysMenu> cfSysMenuPage = new Page<CfSysMenu>(current, limit);
        QueryWrapper<CfSysMenu> cfSysMenuQueryWrapper = new QueryWrapper<>();
        String menuName = cfSysMenuQuery.getMenuName();
        if (StringUtils.isNotEmpty(menuName)) {
            cfSysMenuQueryWrapper.like("MENU_NAME", menuName);
        }
        //调用方法
        cfSysMenuService.page(cfSysMenuPage, cfSysMenuQueryWrapper);
        return R.ok(cfSysMenuPage);
    }

    @PostMapping("/addMenu")
    public R addMenu(@RequestBody CfSysMenu cfSysMenu) {
        boolean result = cfSysMenuService.save(cfSysMenu);
        if (result) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @GetMapping("/getMenu/{id}")
    public R getMenu(@PathVariable Long id) {
        CfSysMenu cfSysMenu = cfSysMenuService.getById(id);
        return R.ok().data("menu", cfSysMenu);
    }
    @GetMapping("/loadMenu")
    public R loadMenu() {
        JSONObject jsonObject = JSONObject.parseObject(redisTemplate.opsForValue().get("cf:sys:menu"));
        return R.ok().data("menu", jsonObject);
    }

    @PostMapping("/updateMenu")
    public R updateMenu(@RequestBody CfSysMenu cfSysMenu) {
        boolean result = cfSysMenuService.updateById(cfSysMenu);
        if (result) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
