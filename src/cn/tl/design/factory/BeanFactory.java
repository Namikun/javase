package cn.tl.design.factory;

import cn.tl.domain.Animal;

public class BeanFactory {

    public static Animal getBean(Class<? extends Animal> c) {
        try {
            return c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}