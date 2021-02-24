package com.wenyao.asserts;

import java.text.MessageFormat;

/**
 * @author wenyao
 * @Description BusinessAssert
 * @Date 2020/6/8 4:01 下午
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    /**
     * newException
     *
     * @param args
     * @return
     */
    @Override
    default BaseException newException(Object... args) {
        String formatMsg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, formatMsg);
    }

    /**
     * newException
     * 
     * @param throwable
     * @param args
     * @return
     */
    @Override
    default BaseException newException(Throwable throwable, Object... args) {
        String formatMsg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, formatMsg, throwable);
    }

}
