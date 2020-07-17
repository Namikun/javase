package cn.tl.classloader;

public class MyClassLoaderTest {

    public static void main(String[] args) throws Exception{
        Class<?> aClass = new MyClassLoader("F:\\").loadClass("cn.tl.domain.Employee");
        System.out.println(aClass.getClassLoader().getClass().getName());
        Object o = aClass.newInstance();
        System.out.println(o);
    }
}
