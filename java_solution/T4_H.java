import org.junit.Test;

public class T4_H {
    /**
     * 我的参考解答：查阅参考答案后解答
     * @param nums1 升序数组
     * @param nums2 升序数组
     * @return 两个数组的中位数
     * 时间复杂度：O(log(m+n))
     *      topK函数：每次循环至少排除k/2个元素，初始k最大为(m+n)/2，循环次数：O(log k) = O(log(m+n))。
     * 空间复杂度：O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = nums1.length + nums2.length;
        if (N%2 == 1){
            return topK(nums1, nums2, (N+1)/2);
        }else {
            double l = topK(nums1, nums2, N/2);
            double r = topK(nums1, nums2, N/2+1);
            return (l + r)/2;
        }
    }

    double topK(int[] nums1, int[] nums2, int k) {
        int point1 = 0;
        int point2 = 0;

        int half;

        while (true){
            // point表示数组尚未删除的第一个元素。point位置超出数组尾说明该数组已删完
            if (point1 == nums1.length){
                return nums2[point2 + k-1];
            }
            if (point2 == nums2.length){
                return nums1[point1 + k-1];
            }
            // point之前的元素已删除，point处元素尚未删除
            if (k == 1){
                return Math.min(nums1[point1], nums2[point2]);
            }

            half = k/2;
            int pivotIndex1 = Math.min(point1+half-1, nums1.length-1);
            int pivotIndex2 = Math.min(point2+half-1, nums2.length-1);

            int pivot1 = nums1[pivotIndex1];
            int pivot2 = nums2[pivotIndex2];

            if (pivot1 < pivot2){
                // 删除point及以前的内容
                k -= pivotIndex1-point1+1;
                point1 = pivotIndex1 + 1;
            }else {
                k -= pivotIndex2-point2+1;
                point2 = pivotIndex2 + 1;
            }
        }
    }

    @Test
    public void Test(){
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{-10,-9,-8}, new int[]{1,2}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{1,3,4}));
    }
}
