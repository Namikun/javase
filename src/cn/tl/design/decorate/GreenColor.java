package cn.tl.design.decorate;

public class GreenColor implements Color {

    @Override
    public void draw() {
        System.out.println(GreenColor.class.getName());
    }

}
