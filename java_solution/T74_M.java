public class T74_M {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix[0].length * matrix.length - 1;
        int mid;
        while (l <= r){
            mid = (l+r)/2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return false;
    }
}
