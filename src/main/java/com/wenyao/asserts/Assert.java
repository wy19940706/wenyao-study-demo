package com.wenyao.asserts;

/**
 * @author wenyao
 * @Description Assert
 * @Date 2020/6/8 10:14 上午
 */
public interface Assert {
    /**
     * 创建异常
     *
     * @param args
     * @return
     */
    BaseException newException(Object... args);

    /**
     * 创建异常
     * 
     * @param throwable
     * @param args
     * @return
     */
    BaseException newException(Throwable throwable, Object... args);

    /**
     * assertNotNull
     * 
     * @param object
     */
    default void assertNotNull(Object object) {
        if (object == null) {
            throw newException(object);
        }
    }

    /**
     * assertNotNull
     * 
     * @param object
     * @param args
     */
    default void assertNotNull(Object object, Object... args) {
        if (object == null) {
            throw newException(args);
        }
    }

}
