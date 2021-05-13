package Sorting_algorithm;

import java.util.Arrays;

/**
 * description: 插入排序 <br>
 * date: 2021-04-13 13:47 <br>
 * author: wangcy <br>
 * version: 1.0 <br>
 */
public class InsertSort {

    private static void swap(int[] arr, int index1, int index2) {
        int a = arr[index1];
        int b = arr[index2];
        arr[index2] = a;
        arr[index1] = b;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,12,3,68,3,2,3,87};
//        int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
        if(arr.length == 1) {
            return;
        }
        for(int i = 1; i < arr.length; i++){
            int a = arr[i];
            for(int j = i - 1; j >= 0; j--){
                int b = arr[j];
                if(a < b) {
                    swap(arr, j, j+1);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
