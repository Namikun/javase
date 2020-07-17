package cn.tl.aop;

import java.io.InputStream;
import java.util.List;

public class AopTest {

    public static void main(String[] args) {
        InputStream is = AopTest.class.getResourceAsStream("config.properties");
        BeanFactory beanFactory = new BeanFactory(is);
        Object bean = beanFactory.getBean("proxy");
        List list = (List) bean;
        list.add(233);
    }
}
