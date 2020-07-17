package cn.tl.aop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    static Properties props = new Properties();

    public BeanFactory(InputStream is) {
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name) {
        Object bean = null;
        try {
            bean = Class.forName(props.get(name).toString()).newInstance();
            if (bean instanceof ProxyBeanFactory) {
                ProxyBeanFactory proxyBeanFactory = (ProxyBeanFactory) bean;
                Object target = Class.forName(props.get(name + ".target").toString()).newInstance();
                Advice advice = (Advice) Class.forName(props.get(name + ".advice").toString()).newInstance();
                proxyBeanFactory.setTarget(target);
                proxyBeanFactory.setAdvice(advice);
                bean = proxyBeanFactory.getProxyBean();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bean;
    }

}
