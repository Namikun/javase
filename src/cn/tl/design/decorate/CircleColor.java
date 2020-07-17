package cn.tl.design.decorate;

/**
 * 具体装饰类
 */
public class CircleColor extends BaseColor {

    public CircleColor(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println(CircleColor.class.getName());
        color.draw();
    }
}
