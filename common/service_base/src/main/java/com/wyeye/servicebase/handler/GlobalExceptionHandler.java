package com.wyeye.servicebase.handler;

import com.wyeye.commonutil.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/20 3:22 下午
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e) {
        e.printStackTrace();
        return R.error();
    }
}
