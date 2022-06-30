package com.py.tooth.core.basic;

/**
 * @author czt
 * @description TODO
 * @date 2022/6/27 20:22 PM
 */
public enum  ErrorInfo {

    NOT_LOGIN(10001,"未登录"),
    WECHAR_CODE_ERROR(10002,"小程序登录code错误"),
    WECHAR_LOGIN_ERROR(10003,"小程序登录失败"),

    UNKNOW_ERROR(500,"系统错误，请联系管理员");

    private Integer code;

    private String message;

    ErrorInfo(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.getCode();
    }

    public String getMessage(){
        return this.getMessage();
    }

}
