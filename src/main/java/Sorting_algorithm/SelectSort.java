package Sorting_algorithm;

import java.util.Arrays;

/**
 * description: 选择排序 <br>
 * date: 2021-04-12 09:32 <br>
 * author: wangcy <br>
 * version: 1.0 <br>
 */
public class SelectSort {

    private static void swap(int[] arr, int index1, int index2) {
        int a = arr[index1];
        int b = arr[index2];
        arr[index2] = a;
        arr[index1] = b;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,12,3,68,3,2,3,87};
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length - 1; i++) {

            int lessIndex = i;

            for(int j = i + 1; j < arr.length; j++){
                if(arr[lessIndex] > arr[j]){
                    lessIndex = j;
                }
            }

            if(lessIndex != i) {
                swap(arr, i, lessIndex);
            }

            System.out.println("第" + (i + 1) + "次排序结果为：" + Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));
    }

}
