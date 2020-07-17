package cn.tl.aop;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {

    @Override
    public void beforeMethod(Method method) {
        System.out.println("beforeMethod");
    }

    @Override
    public void afterMethod(Method method) {
        System.out.println("afterMethod");
    }
}
