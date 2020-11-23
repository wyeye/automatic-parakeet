package com.wyeye.commonutil;
/**
 * 后台返回状态码
 *
 * @author wyeye
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/23 9:14 上午
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    ERROR(201, "失败");

    public Integer type;
    public String message;

    ResultCode(Integer type, String message) {
        this.type = type;
        this.message = message;
    }
}
