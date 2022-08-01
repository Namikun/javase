package cn.tl.algorithm;

import java.util.Arrays;

/**
 * 找出数组中所有左边比它小，右边比它大的数
 */
public class Increase {

    // 1 2 12 15
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 3, 9, 5, 6, 12, 15};
        int[] b = new int[a.length];
        int temp = a[0];
        for (int i = 0; i < a.length; i++) {
            if (temp <= a[i]) {
                temp = a[i];
                b[i]++;
            }
        }
        System.out.println(Arrays.toString(b));

        temp = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            if (temp >= a[i]) {
                temp = a[i];
                b[i]++;
            }
        }
        System.out.println(Arrays.toString(b));

        for (int i = 0; i < a.length; i++) {
            if (b[i] == 2) {
                System.out.print(a[i] + " ");
            }
        }

    }

}
