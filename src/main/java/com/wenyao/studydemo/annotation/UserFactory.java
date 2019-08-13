package com.wenyao.studydemo.annotation;

import java.lang.reflect.Method;

/**
 * Created by Think on 2019/2/18
 */
public class UserFactory {
    /**
     * create()
     * 
     * @return
     */
    @Check
    public static User create() {
        User user = new User();
        Method[] methods = User.class.getDeclaredMethods();
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

}
