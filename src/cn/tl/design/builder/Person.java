package cn.tl.design.builder;

public class Person {

    private int id;
    private String name;
    private String sex;
    private String hobby;

    public static class Builder {
        private int id;
        private String name;
        private String sex;
        private String hobby;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
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
        this.id = builder.id;
        this.name = builder.name;
        this.sex = builder.sex;
        this.hobby = builder.hobby;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getHobby() {
        return hobby;
    }
}
