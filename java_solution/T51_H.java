import java.util.*;

public class T51_H {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        putQueens(solutions, n, 0, queens, columns, diagonals1, diagonals2);
        return solutions;
    }
    /*
        raw表示已放完的皇后数量（同时也是当前应当放置的皇后的行数）
        raw取值为0～N。
     */
    public void putQueens(List<List<String>> solutions, int N, int raw, int[] queens, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if (raw == N){
            solutions.add(generateBoard(queens));
        }else {
            // 将第raw行的皇后放在第col列
            for (int col = 0; col < N; col++) {
                if (columns.contains(col)){
                    continue;
                }
                int d1 = raw + col;
                if(diagonals1.contains(d1)){
                    continue;
                }
                int d2 = raw - col;
                if (diagonals2.contains(d2)){
                    continue;
                }

                // [raw, col]处满足放置条件，开始放置皇后。
                queens[raw] = col;
                columns.add(col);
                diagonals1.add(d1);
                diagonals2.add(d2);

                // 第raw行放置皇后后，下面开始放置第raw+1行的皇后
                putQueens(solutions, N, raw+1, queens, columns, diagonals1, diagonals2);

                // 拿掉第raw行的皇后
                queens[raw] = -1;
                columns.remove(col);
                diagonals1.remove(d1);
                diagonals2.remove(d2);
                // 在下一轮循环中，尝试在其他col放置第raw行的皇后
            }
        }
    }

    public List<String> generateBoard(int[] queens){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder raw = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (j != queens[i]){
                    raw.append('.');
                }else {
                    raw.append("Q");
                }
            }
            board.add(String.valueOf(raw));
        }
        return board;
    }
}
