package cn.tl.design.decorate;

/**
 * 抽象装饰类
 */
public abstract class BaseColor implements Color {

    protected Color color;

    public BaseColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        color.draw();
    }
}
