package com.wenyao.asserts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 返回实体枚举
 * @author wenyao
 * @Date 2020/6/8 4:06 下午
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {
    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND(7002, "Licence not found.");

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}
