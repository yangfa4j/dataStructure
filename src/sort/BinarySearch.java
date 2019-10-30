package sort;

import java.util.ArrayList;

/**
 * @Date 2019/8/5
 * @Author YF
 * @Description 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,3, 9, 10, 12,15};
        ArrayList list = new ArrayList();

    }

    public static int  binarySearch(int []arr, int left, int right, int x) {
        int mid = (left + right)/2;
        int midValue = arr[mid];
        if (left > right){
            return -1;
        }
        if (x > midValue){
            return binarySearch(arr, mid+1, right, x);
        }
        else if (x < midValue){
            return binarySearch(arr, left, mid-1, x);
        }else {
            return mid;
        }
    }

}

