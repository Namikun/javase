package cn.tl.clone;

/**
 * clone方法是浅拷贝，拷贝的对象和原来的对象不相等，但对象内部的引入变量指向同一个对象
 * 深拷贝，对象内部的引用对象也需要clone
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal a = new Animal();
        a.cat = new Cat();
        Animal clone = (Animal) a.clone();
        System.out.println("Animal: " + (a == clone));
        System.out.println("cat:" + (a.cat == clone.cat));
    }
}
