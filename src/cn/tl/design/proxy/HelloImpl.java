package cn.tl.design.proxy;

public class HelloImpl implements Hello {

    @Override
    public String sayHello(String name) {
        return name + "2333";
    }
}
