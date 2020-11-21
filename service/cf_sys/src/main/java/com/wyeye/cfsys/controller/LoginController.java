package com.wyeye.cfsys.controller;

import com.wyeye.commonutil.R;
import org.springframework.web.bind.annotation.*;

/**
 * 登陆
 *
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/21 2:45 下午
 */
@RestController
@RequestMapping("/sys/user")
@CrossOrigin
public class LoginController {
    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "");
    }


}
