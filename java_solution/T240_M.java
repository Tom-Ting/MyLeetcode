import org.junit.Test;

public class T240_M {
    /**
     *
     * @param matrix x取值[0, matrix.length]，y取值[0, matrix[0].length]。
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length-1;

        while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length){
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target){
        int x = matrix.length-1;
        int y = 0;

        while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length){
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] > target){
                x--;
            }else {
                y++;
            }
        }
        return false;
    }

    @Test
    public void Test(){
        System.out.println(searchMatrix2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));

        System.out.println(searchMatrix2(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 20));

        System.out.println(searchMatrix2(new int[][]{{-5}}, -5));

        System.out.println(searchMatrix2(new int[][]{{1,1}}, 2));

        System.out.println(searchMatrix2(new int[][]{{1,4}, {2, 5}}, 2));
    }
}
