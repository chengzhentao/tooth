package com.py.tooth.core.basic;

import lombok.Data;

import java.io.Serializable;

/**
 * @author czt
 * @description 规范化返回结果
 * @date 2022/6/27 20:17 PM
 */
@Data
public class Result<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private Result(){
        this.code = Constant.SUCCESS;
    }

    private Result(T t){
        this.code = Constant.SUCCESS;
        this.data = t;
    }

    private Result(int code, String message){
        this.code = code;
        this.message = message;
    }

    private Result(ErrorInfo errorInfo){
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public static<T> Result success(){
        return new Result();
    }
    public static<T> Result success(T t){
        return new Result(t);
    }

    public static Result fail(String message){
        return new Result(1, message);
    }

    public static Result fail(ErrorInfo errorInfo){
        return new Result(errorInfo);
    }

    public boolean isSuccess(){
        return this.getCode()  == Constant.SUCCESS;
    }
}
