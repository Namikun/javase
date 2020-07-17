package cn.tl.reflect;

import java.lang.reflect.Array;

public class ArrayReflectTest {

    public static void main(String[] args) {
        Object[] a = {1, "2", 3, 4};
        print(a);
    }

    public static void print(Object obj) {
        Class<?> aClass = obj.getClass();
        if (aClass.isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object o = Array.get(obj, i);
                System.out.println(o);
            }
        } else {
            System.out.println(obj);
        }
    }
}
