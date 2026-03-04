package T295_H_数据流中的中位数;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    List<Integer> stream;

    public MedianFinder() {
        stream = new ArrayList<>();
    }

    /**
     * 时间复杂度：O(n)：ArrayList类插入元素的时间复杂度为O(n)
     * 空间复杂度：O(1)：不需要辅助空间
     * @param num
     */
    public void addNum(int num) {
        if (stream.isEmpty()){
            stream.add(num);
        }else {
            int left = 0;
            int right = stream.size()-1;
            while (left < right){
                int mid = (left+right)/2;
                if (stream.get(mid) == num){
                    stream.add(mid+1, num);
                    return;
                }else if (stream.get(mid) < num){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
            int mid = (left+right)/2;
            if (stream.get(mid) <= num){
                stream.add(mid+1, num);
            } else {
                stream.add(mid, num);
            }
        }
    }

    /**
     * 时间复杂度：O(1)：只进行了简单的算术运算和数组访问，ArrayList 的 get(index)是 O(1)。
     * 空间复杂度：O(1)：只用了几个局部变量
     * @return double类型的中位数
     */
    public double findMedian() {
        boolean isSingle = stream.size()%2 == 1;
        return isSingle ? stream.get((stream.size()-1)/2) : (double)(stream.get(stream.size()/2)+stream.get(stream.size()/2-1))/2;
    }

    @Test
    public void Test(){
//        MedianFinder mf1 = new MedianFinder();
//        mf1.addNum(1);
//        mf1.addNum(2);
//        System.out.println(mf1.findMedian());
//        mf1.addNum(3);
//        System.out.println(mf1.findMedian());

        MedianFinder mf2 = new MedianFinder();
        mf2.addNum(6);
        System.out.println(mf2.findMedian());
        mf2.addNum(10);
        System.out.println(mf2.findMedian());
        mf2.addNum(2);
        System.out.println(mf2.findMedian());
        mf2.addNum(6);
        System.out.println(mf2.findMedian());
        mf2.addNum(5);
        System.out.println(mf2.findMedian());
        mf2.addNum(0);
        System.out.println(mf2.findMedian());
        mf2.addNum(6);
        System.out.println(mf2.findMedian());
        mf2.addNum(3);
        System.out.println(mf2.findMedian());
        mf2.addNum(1);
        System.out.println(mf2.findMedian());
        mf2.addNum(0);
        System.out.println(mf2.findMedian());
        mf2.addNum(0);
        System.out.println(mf2.findMedian());

    }
}
