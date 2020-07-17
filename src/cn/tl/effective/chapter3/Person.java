package cn.tl.effective.chapter3;

/**
 * @author namikun
 * @date 2020/7/12
 */
public class Person implements Cloneable {

    private int age;

    // 需要clone的字段不能使用final修饰
    private String[] hobby;

    public Person(int age, String[] hobby) {
        this.age = age;
        this.hobby = hobby;
    }

    /**
     * clone方式默认浅拷贝，对象中的对象也需要调用clone方法，才是深拷贝
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person result = (Person) super.clone();
        result.hobby = hobby.clone();
        return result;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobby() {
        return hobby;
    }
}
