package cn.tl.effective.charpter6;

import java.util.EnumSet;

/**
 * @author namikun
 * @date 2020/7/19
 */
public class Worker {

    private String name;

    private EnumSet<MyStrategyEnum> myStrategyEnum;

    public Worker(String name, EnumSet<MyStrategyEnum> myStrategyEnum) {
        this.name = name;
        this.myStrategyEnum = myStrategyEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumSet<MyStrategyEnum> getMyStrategyEnum() {
        return myStrategyEnum;
    }

    public void setMyStrategyEnum(EnumSet<MyStrategyEnum> myStrategyEnum) {
        this.myStrategyEnum = myStrategyEnum;
    }
}
