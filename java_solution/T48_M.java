import org.junit.Test;

public class T48_M {
    public void rotate(int[][] matrix) {

    }
    @Test
    public void Test(){
        rotate(new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
                });
        rotate(new int[][]{
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        });
    }
}

/*
    1. 位置映射问题
    2. 奇数/偶数截半问题
    3. 整数除法问题
 */
