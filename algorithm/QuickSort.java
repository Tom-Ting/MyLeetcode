import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        // 选择基准值（取最右值）
        int pivot = arr[right];

        int i = left, j = right - 1;

        // 分区操作
        while (i <= j) {
            // 从左向右找大于等于基准的元素
            while (i <= j && arr[i] < pivot) i++;
            // 从右向左找小于基准的元素
            while (i <= j && arr[j] > pivot) j--;

            if (i <= j) {
                // 交换元素
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // 将基准值放回正确位置
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        // 递归排序左右两部分
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    @Test
    public void Test(){
        int[] array1 = {3, 6, 8, 10, 1, 2, 1};
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {43, 67, 21, 89, 12, 54, 33, 76, 98, 5, 62, 19, 87, 41, 28, 73, 55, 90, 14, 37, 82, 9, 64, 31, 78, 46, 23, 59, 16, 71};
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
