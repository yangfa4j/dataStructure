package sort;

import java.util.Arrays;

/**
 * @Date 2019/8/5
 * @Author YF
 * @Description 快速排序
 */
public class quickSort {

    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, -2};
        int[] quick = quick(array,0,5);
        System.out.println(Arrays.toString(array));

    }

    public static int[] quick(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int pivot = array[(left+right)/2];
        int temp = 0;
        while (l < r){
            while (array[l] < pivot){
                l++;
            }
            while (array[r] > pivot){
                r--;
            }
            if (l >= r){
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if (array[l] == pivot){
                r--;
            }
        }
        return array;
    }



}

