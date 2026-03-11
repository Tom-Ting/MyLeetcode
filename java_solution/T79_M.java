import org.junit.Test;

import java.util.Objects;

public class T79_M {
    /**
     * 我的参考题解：参考官方思路。
     * @param board 尺寸为m × n
     * @param word 长度为L
     * @return 是否存在目标单词
     * 时间复杂度：O(m × n × 3ᴸ)
     *      起点数量：m × n
     *      除首节点，每个节点有最多3个子节点，树深度最多L。故时间开销为3ᴸ
     * 空间复杂度：O(m × n + L)
     *      visited数组：O(m × n)
     *      递归调用栈：O(L)。最大递归深度为L
     *      字符串拼接和裁剪：O(L)
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHeadAt(board, visited, i, j, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existHeadAt(char[][] board, boolean[][] visited, int i, int j, String word){
        if (Objects.equals(word, "")){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if (visited[i][j]){
            return false;
        }
        if (board[i][j] == word.charAt(0)){
            visited[i][j] = true;
            String ord = word.substring(1);
            boolean exists =  existHeadAt(board, visited, i - 1, j, ord) ||
                    existHeadAt(board, visited, i, j - 1, ord) ||
                    existHeadAt(board, visited, i + 1, j, ord) ||
                    existHeadAt(board, visited, i, j + 1, ord);
            visited[i][j] = false;
            return exists;
        }
        return false;
    }
    @Test
    public void Test(){
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));

        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));

        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));

        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "AB"));

        System.out.println(exist(new char[][]{
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        }, "aaaaaaaaaaaaaaaaaaaaaaaaaa"));

        System.out.println(exist(new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        }, "AAB"));
    }
}
