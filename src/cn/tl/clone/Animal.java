package cn.tl.clone;

public class Animal implements Cloneable {

    public Cat cat;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Animal clone = (Animal) super.clone();
        clone.cat = (Cat) cat.clone();
        return clone;
    }
}
