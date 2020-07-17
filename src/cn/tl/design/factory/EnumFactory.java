package cn.tl.design.factory;

import cn.tl.domain.Animal;
import cn.tl.domain.Cat;
import cn.tl.domain.Dog;

public enum EnumFactory {

    Dog, Cat;

    public Animal create() {
        switch (this) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            default:
                return null;
        }
    }
}
