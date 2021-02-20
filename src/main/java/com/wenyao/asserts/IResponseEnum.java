package com.wenyao.asserts;

/**
 * @Description 异常返回实体枚举
 * @author wenyao
 * @Date 2020/6/8 3:57 下午
 */
public interface IResponseEnum {
    /**
     * 
     * @return
     */
    int getCode();

    /**
     * 
     * @return
     */
    String getMessage();
}
