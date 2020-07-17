package cn.tl.design.strategy;

public class Test {

    public static void main(String[] args) {
        Share share = ShareFactory.getInstance("wechat");
        share.share();
    }
}
