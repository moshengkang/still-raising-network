package com.keepstudy.util.rest.support;

/**
 * @author: 莫升康
 * @e-mail: 1634414600@qq.com
 * @Date: 2020/4/2 15:22
 * @Description:
 */
public class RemoteInvokeException extends BaseException {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param code
     *            错误编码
     * @param message
     *            错误消息
     * @param cause
     *            错误原因
     */
    public RemoteInvokeException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    /**
     * @param code
     *            错误编码
     * @param message
     *            错误消息
     */
    public RemoteInvokeException(int code, String message) {
        super(code, message);
    }

    /**
     * @param code
     *            错误编码
     * @param cause
     *            错误消息
     */
    public RemoteInvokeException(int code, Throwable cause) {
        super(code, cause);
    }

    /**
     * @param message
     *            错误消息
     * @param cause
     *            错误原因
     */
    public RemoteInvokeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     *            错误消息
     */
    public RemoteInvokeException(String message) {
        super(message);
    }

    /**
     * @param cause
     *            错误原因
     */
    public RemoteInvokeException(Throwable cause) {
        super(cause);
    }
}
