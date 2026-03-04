import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    /**
     * 递归快速排序。以右端点为枢轴，递增排序
     * @param arr 待排序数组
     * @param left 左边界（含）
     * @param right 右边界（含）
     */
    public static void quickSort1(int[] arr, int left, int right) {
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
        quickSort1(arr, left, i - 1);
        quickSort1(arr, i + 1, right);
    }

    /**
     * 递归快速排序。以左端点为枢轴，递增排序
     * @param arr 待排序数组
     * @param left 左边界（含）
     * @param right 右边界（含）
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        int pivot = arr[left];
        int l = left+1;
        int r = right;

        while (l <= r){
            while (l <= r && arr[r] > pivot) r--;
            while (l <= r && arr[l] < pivot) l++;
            if (l <= r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        arr[left] = arr[r];
        arr[r] = pivot;

        quickSort(arr, left, r-1);
        quickSort(arr, r+1, right);
    }

    public static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[left];  // 选择最左元素作为基准
        int l = left + 1;
        int r = right;

        while (l <= r) {
            // 关键修正1：从左向右找大于等于pivot的元素
            while (l <= r && arr[l] < pivot) l++;

            // 关键修正2：从右向左找小于等于pivot的元素
            while (l <= r && arr[r] > pivot) r--;

            if (l <= r) {
                // 交换元素
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }

        // 关键修正3：将基准值放到正确位置
        // 此时 r 指向最后一个小于等于pivot的元素
        int temp = arr[left];
        arr[left] = arr[r];
        arr[r] = temp;

        // 递归排序左右两部分
        quickSort2(arr, left, r - 1);
        quickSort2(arr, r + 1, right);
    }

    @Test
    public void Test(){
        int[] array1 = {3, 6, 8, 10, 1, 2, 1};
        quickSort(array1, 0, array1.length - 1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {43, 67, 21, 89, 12, 54, 33, 76, 98, 5, 62, 19, 87, 41, 28, 73, 55, 90, 14, 37, 82, 9, 64, 31, 78, 46, 23, 59, 16, 71};
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {78, 67, 21, 89, 12, 54, 33, 76, 98, 5, 62, 19, -1};
        quickSort(array3, 0, array3.length - 1);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {78, 67, 21, 89, 12, 54, 33, 76, 98, 5, 62, 19, 100};
        quickSort(array4, 0, array4.length - 1);
        System.out.println(Arrays.toString(array4));
    }
}
