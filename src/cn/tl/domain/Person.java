package cn.tl.domain;

public class Person {

    private Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private static ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();

    private String name;
    private int age;
    public Student student;

    /**
     * 线程间独立，所以不需要同步
     * @return
     */
    public static Person getPerson(){
        Person person = personThreadLocal.get();
        if (person == null) {
            person = new Person();
            personThreadLocal.set(person);
        }

        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
