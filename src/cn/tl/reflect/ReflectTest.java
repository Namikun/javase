package cn.tl.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 动态的加载类及其成员变量、构造函数和方法
 * 提高了程序的扩展性
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("cn.tl.domain.Employee");
        //调用空参构造函数
        //Object instance = aClass.newInstance();
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class, int.class);
        Object instance = constructor.newInstance("tom", 22);
        Method getAge = aClass.getDeclaredMethod("getAge");
        System.out.println(getAge.invoke(instance));
        Method say = aClass.getDeclaredMethod("say");
        //调用静态方法对象值传null
        say.invoke(null);
    }
}
