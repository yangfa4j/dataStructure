package sort;

import java.util.Arrays;

/**
 * @Date 2019/8/5
 * @Author YF
 * @Description
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] select = select(arr);
        System.out.println(Arrays.toString(select));

    }

    public static int[] select(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
        return array;
    }
}
