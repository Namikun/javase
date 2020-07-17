package cn.tl.design.builder;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Person.Builder().id(1).name("asdfd").build().getName());
    }
}
