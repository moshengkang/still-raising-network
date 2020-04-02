package com.keepstudy.util.rest.support;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/4/2 15:23
 * @Description:
 */
public class BaseException extends RuntimeException implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误编码
     */
    private int code;

    /**
     * 默认构造函数
     */
    public BaseException() {
        super();
    }

    /**
     * @param message 错误消息
     * @param cause 异常原因
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     * @param message 错误消息
     */
    public BaseException(String message) {
        super(message);
    }
    /**
     * @param cause 异常根原因
     */
    public BaseException(Throwable cause) {
        super(cause);
    }
    /**
     *
     * @param code 错误编码
     * @param message 错误消息
     * @param cause 异常原因
     */
    public BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    /**
     *
     * @param code 错误编码
     * @param message 错误消息
     */
    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }
    /**
     *
     * @param code 错误编码
     * @param cause 异常原因
     */
    public BaseException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * 取得错误编码
     * @return
     */
    public int getCode() {
        return code;
    }
    /**
     * 设置错误编码
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

}