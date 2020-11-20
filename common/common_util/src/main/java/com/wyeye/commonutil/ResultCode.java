package com.wyeye.commonutil;

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
