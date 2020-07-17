package cn.tl.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloProxy implements InvocationHandler {

    private Object target;

    public HelloProxy(Object target) {
        this.target = target;
    }

    public Object getProxyBean() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法执行之前可以开启事务
        Object value = method.invoke(target, args);
        // 方法执行之后可以关闭事务
        return value;
    }
}
