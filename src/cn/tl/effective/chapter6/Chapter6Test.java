package cn.tl.effective.chapter6;

import java.util.EnumSet;

import static cn.tl.effective.chapter6.MyStrategyEnum.*;

/**
 * @author namikun
 * @date 2020/7/18
 */
public class Chapter6Test {

    public static void main(String[] args) {
        System.out.println(MyEnum.Spring.see());
        System.out.println(MyEnum.Spring instanceof MyEnum);

        Worker[] workers = new Worker[]{
                new Worker("lilei", EnumSet.of(Friday, Saturday, Sunday)),
                new Worker("susan", EnumSet.of(Monday, Tuesday, Friday)),
                new Worker("lucy", EnumSet.of(Thursday, Friday))
        };
        EnumSet<MyStrategyEnum> myStrategyEnums = EnumSet.allOf(MyStrategyEnum.class);
        for (Worker worker : workers) {
            myStrategyEnums.retainAll(worker.getMyStrategyEnum());
        }

        System.out.println(myStrategyEnums);

        Phase.Transition transition = Phase.Transition.get(Phase.SOLID, Phase.LIQUID);
        System.out.println(transition);
    }
}
