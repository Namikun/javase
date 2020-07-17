package cn.tl.effective.chapter2;

import java.util.Date;

/**
 * 建造者模式
 * 使用场景：对象的参数个数 >= 4， 参数不可变
 *
 * @author namikun
 * @date 2020/7/5
 */
public class Person {

    private final String name;

    private final String sex;

    private final int age;

    private final Date birthday;

    private final String hobby;

    public static class Builder {
        private String name;

        private String sex;

        private int age;

        private Date birthday;

        private String hobby;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder hobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        birthday = builder.birthday;
        hobby = builder.hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
