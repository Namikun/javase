package cn.tl.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelTest {

    public static void main(String[] args) {
        //对象并行流操作 使用collect，基本类型并行流操作 使用reduce
        System.out.println(Stream.of("1", "2", "3", "4").parallel().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());

        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(3).collect(Collectors.toList());
        long start = System.currentTimeMillis();
        int total = parallelWithReduce(list);
        System.out.println("time: " + (System.currentTimeMillis() - start));
        System.out.println(total);

        //System.out.println(Arrays.toString(parallel(4)));

        double[] arr = {0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(average(arr, 3)));
    }

    //并行时，注意初始值，乘法初始值为1，并行运算才不会影响结果，加法初始值为0
    public static int parallelWithReduce(List<Integer> lists) {
        return lists.parallelStream().reduce(1, (acc, x) -> acc = x * acc);
    }

    public static double[] parallel(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i + 1);
        return values;
    }

    public static double[] average(double[] arr, int size) {
        //每一个元素为每个角标（包括当前角标）之前所有的元素之和
        Arrays.parallelPrefix(arr, Double::sum);
        for (double v : arr) {
            System.out.println(v);
        }
        return IntStream.range(size - 1, arr.length).mapToDouble(x -> {
            if (x - size == -1) {
                return arr[x] / size;
            } else {
                return (arr[x] - arr[x - size]) / size;
            }
        }).toArray();
    }
}
