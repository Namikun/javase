package cn.tl.design.proxy;

/**
 * JDK的动态代理
 * 代理类中持有HelloProxy的引用handler
 * Method method, Object[] args都是通过反射从接口Hello中获取的
 */
public class Test {

    public static void main(String[] args) {
        Hello proxy = (Hello) new HelloProxy(new HelloImpl()).getProxyBean();
        //proxy.sayHello("Fuck")实际上调用的是this.handler.invoke(this, "sayHello", new Object[]{"Fuck"})
        System.out.println(proxy.sayHello("Fuck"));
        System.out.println(proxy.getClass().getName());
    }
}
