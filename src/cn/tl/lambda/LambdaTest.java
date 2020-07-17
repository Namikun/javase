package cn.tl.lambda;

public class LambdaTest {

    public static void output(String s, Func<String> fun) {
        fun.out(s);
    }

    public static void main(String[] args) {
        String str = "hello ";

        output("world", x -> System.out.println(str + x));

        //output("world", new LambdaTest().new LambdaTest$$Lambda$1(str));
    }

    //lambda表达式生成一个私有静态方法，表达式右边为方法体，涉及到的参数全部作为方法参数
    /*private static void lambda$main$0(String arg0, String x) {
        System.out.println(arg0 + x);
    }*/

    //函数式接口实现类，实现方法调用私有静态方法
   /* final class LambdaTest$$Lambda$1 implements Func {
        private final String arg$1;

        private LambdaTest$$Lambda$1(String var1) {
            this.arg$1 = var1;
        }

//        private static Func get$Lambda(String var0) {
//            return new LambdaTest$$Lambda$1(var0);
//        }

        public void out(Object var1) {
            LambdaTest.lambda$main$0(this.arg$1, (String) var1);
        }
    }*/
}