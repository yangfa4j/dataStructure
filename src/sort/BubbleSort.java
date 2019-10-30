package sort;

import java.util.Arrays;

/**
 * @Date 2019/8/5
 * @Author YF
 * @Description 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, -2};
        int[] bubble = bubble(array);
        System.out.println(Arrays.toString(array));

    }

    public static int[] bubble(int[] array) {
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        return array;
    }
}

