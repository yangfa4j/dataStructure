package sort;

import java.util.Arrays;

/**
 * @Date 2019/8/12
 * @Author YF
 * @Description
 */
public class InsertSort2 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 8, 9, 6, 5, 7};
        int[] select = insert2(arr);
        System.out.println(Arrays.toString(select));

    }

    public static int[] insert2(int[] array) {
        for (int i = 1; i < array.length ; i++) {
            int insertVal = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < array[insertIndex]){
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }
            if(insertIndex + 1 != i){
                array[insertIndex + 1] = insertVal;
            }
        }
        return array;
    }
}
