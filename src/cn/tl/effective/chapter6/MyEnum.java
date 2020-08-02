package cn.tl.effective.chapter6;

/**
 * @author namikun
 * @date 2020/7/18
 * 特定于常量方法的实现
 * 如果添加枚举常量，会强制实现方法
 * 相比于switch语句，复杂了一点，但是更安全。
 * <p>
 * 缺点： 共享代码变难了，因为每一个常量都要实现方法（解决方法：策略枚举 cn.tl.effective.charpter6.MyStrategyEnum）
 */
public enum MyEnum {

    Spring {
        @Override
        public String see() {
            return "樱花";
        }
    },
    Summer {
        @Override
        public String see() {
            return "大海";
        }
    },
    Autumn {
        @Override
        public String see() {
            return "红叶";
        }
    },
    Winter {
        @Override
        public String see() {
            return "白雪";
        }
    };

    public abstract String see();

    public static void test(int styles) {
        System.out.println(styles);
    }
}
