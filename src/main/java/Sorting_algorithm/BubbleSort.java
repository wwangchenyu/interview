package Sorting_algorithm;

import java.util.Arrays;

/**
 * description: 冒泡排序 <br>
 * date: 2021-04-09 17:23 <br>
 * author: wangcy <br>
 * version: 1.0 <br>
 */
public class BubbleSort {

    private static void swap(int[] arr, int index1, int index2) {
        int a = arr[index1];
        int b = arr[index2];
        arr[index2] = a;
        arr[index1] = b;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,12,3,68,3,2,3,87};
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length - 1; i++) {   //遍历的趟数
            for(int j = 0; j < arr.length - 1 - i; j++) {   //
                int a = arr[j];
                int b = arr[j+1];
                if(a > b) {
                    swap(arr,j, j+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
