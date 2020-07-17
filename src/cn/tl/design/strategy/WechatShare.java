package cn.tl.design.strategy;

/**
 * 具体策略类
 */
public class WechatShare implements Share {
    @Override
    public void share() {
        //相关的业务
        System.out.println("wechat share");
    }
}
