package cn.tl.effective.charpter6;

/**
 * @author namikun
 * @date 2020/7/18
 * <p>
 * 策略枚举, 使用私有内部枚举类
 */
public enum MyStrategyEnum {

    Monday, Tuesday, Wednesday, Thursday, Friday,
    Saturday(DayType.Weekend), Sunday(DayType.Weekend);

    private final DayType dayType;

    MyStrategyEnum() {
        this(DayType.Weekday);
    }

    MyStrategyEnum(DayType dayType) {
        this.dayType = dayType;
    }

    public double pay(double time, double money_h) {
        return dayType.pay(time, money_h);
    }

    private enum DayType {
        Weekday {
            @Override
            public double pay(double time, double money_h) {
                return time * money_h;
            }
        }, Weekend {
            @Override
            public double pay(double time, double money_h) {
                return time * money_h * 2;
            }
        };

        public abstract double pay(double time, double money_h);

    }
}
