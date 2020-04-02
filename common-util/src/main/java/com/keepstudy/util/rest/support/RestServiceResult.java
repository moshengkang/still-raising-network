package com.keepstudy.util.rest.support;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/4/2 15:20
 * @Description:
 */
public class RestServiceResult<T> {
    public static int CODE_UNKNOW = -1;//未知错误码

    public static int CODE_SUCCSUCCESS = 0;//成功码

    /**
     * 状态码
     */
    private int status = CODE_SUCCSUCCESS;

    /**
     * 错误信息
     */
    private String errorInfo;

    /**
     * 返回结果
     */
    private T result;

    public RestServiceResult() {}

    public RestServiceResult(T o) {
        this.result = o;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
