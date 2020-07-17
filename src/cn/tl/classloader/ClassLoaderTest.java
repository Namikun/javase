package cn.tl.classloader;

/**
 * 类加载方式采取父亲委托机制
 * Bootstrap C++编写，加载\jre\lib\rt.jar
 * ExtClassLoader  加载\jre\lib\ext\*.jar
 * AppClassLoader  加载classpath指定路径下的*.jar
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader.getClass().getName());
        System.out.println(int.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(int[].class.getClassLoader());
        System.out.println(System.class.getClassLoader());

        if (classLoader != null) {
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);

    }
}
