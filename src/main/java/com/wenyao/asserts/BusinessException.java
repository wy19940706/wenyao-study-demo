package com.wenyao.asserts;

/**
 * @author wenyao
 * @Description 业务异常
 * @Date 2020/6/8 10:35 上午
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = -1;

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        // super(responseEnum, args, message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        // super(responseEnum, args, message, cause);
    }


}
