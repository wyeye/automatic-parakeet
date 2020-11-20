package com.wyeye.commonutil;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果的类
 *
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/20 11:21 上午
 */
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 把构造方法私有
     *
     * @param
     * @return
     * @author wyeye
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/20 11:16 上午
     */
    private R() {
    }


    /**
     * 成功静态方法
     *
     * @param
     * @return com.wyeye.commonutil.R
     * @author wyeye
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/20 11:16 上午
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.type);
        r.setMessage(ResultCode.SUCCESS.message);
        return r;
    }

    /**
     * 成功静态方法
     *
     * @param page
     * @return com.wyeye.commonutil.R
     * @author wyeye
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/20 11:15 上午
     */
    public static R ok(Page page) {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.type);
        r.setMessage(ResultCode.SUCCESS.message);
        r.setData(JSON.parseObject(JSON.toJSONString(page), Map.class));
        return r;
    }

    /**
     * 失败静态方法
     *
     * @param
     * @return com.wyeye.commonutil.R
     * @author wyeye
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/20 11:17 上午
     */
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR.type);
        r.setMessage(ResultCode.ERROR.message);
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
