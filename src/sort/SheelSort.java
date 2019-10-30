package sort;

import java.util.Arrays;

/**
 * @Date 2019/8/22
 * @Author YF
 * @Description
 */
public class SheelSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        System.out.println(Arrays.toString(sheel(arr)));
    }

    public static int[] sheel(int[] array) {
        int temp = 0;
        for (int gap = array.length / 2; gap > 0  ; gap /= 2) {  //定义步长
            for (int i = gap; i < array.length ; i++) {
                for (int j = i-gap; j >= 0 ; j-=gap) {
                    if (array[j] > array [j+gap]){
                        temp = array[j];
                        array[j] = array[j+gap];
                        array[j+gap] = temp;
                    }
                }
            }
        }
        return array;
    }
}
