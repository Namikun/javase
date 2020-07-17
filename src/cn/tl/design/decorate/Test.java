package cn.tl.design.decorate;

public class Test {

    public static void main(String[] args) {
        new CircleColor(new GreenColor()).draw();
    }
}
