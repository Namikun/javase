package cn.tl.algorithm;

import java.util.Arrays;

/**
 * 空间复杂度：非递归一般为O(1)，递归一般为递归次数
 * 快速排序：时间复杂度：O(nlogn)，最坏情况O(n^2)，比如数组逆序。空间复杂度：O(logn)，最坏情况：O(n)
 * 选择排序：时间复杂度O(n^2)，空间复杂度：O(1)
 * 冒泡排序：时间复杂度O(n^2)，空间复杂度：O(1)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 6, 4, 67, 1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left;
        int r = right;
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[left] <= base) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
        }

        arr[left] = base;

        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }
}
