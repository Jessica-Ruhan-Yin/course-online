package com.course.server.exception;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/14
 */
public enum BusinessExceptionCode {

    USER_LOGIN_NAME_EXIST("登录名已存在"),
    LOGIN_ERROR("用户名不存在或密码不正确")
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}