package com.keepstudy.util;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/3/25 14:53
 * @Description: 通用返回结果集封装
 */
public class Result<T> implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private int errorCode;

    /**
     * 系统Code
     */
    private String sysCode;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 结果封装
     */
    private T model;

    /**
     * 成功时间
     */
    private Date successTime;

    public static <T> Result<T> createSuccRes(T model) {
        Result<T> result = new Result<T>(true);
        result.setModel(model);
        return result;
    }

    public static <T> Result<T> createSuccRes(T model, Date successTime) {
        Result<T> result = new Result<T>(true);
        result.setModel(model);
        result.setSuccessTime(successTime);
        return result;
    }

    public static <T> Result<T> createFailedRes(int errorCode, String errorMsg) {
        Result<T> result = new Result<T>(false);
        result.setErrorCode(errorCode);
        result.setErrorMsg(errorMsg);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result(boolean success) {
        this.success = success;
    }
    public Result() {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", errorCode=" + errorCode +
                ", sysCode='" + sysCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", model=" + model +
                ", successTime=" + successTime +
                '}';
    }
}