package sort;

import java.util.Arrays;

/**
 * @Date 2019/8/12
 * @Author YF
 * @Description
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 8, 9, 6, 5, 7};
        int[] select = insert(arr);
        System.out.println(Arrays.toString(select));

    }

    public static int[] insert(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; (j > 0) && array[j] < array[j - 1]; j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return array;
    }
}
