import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T118_E {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            row.add(1);
            ans.add(row);
        }
        ans.get(0).remove(1);
        return ans;
    }

    @Test
    public void Test(){
        System.out.println(generate(5));
    }
}
/*
    观察一下：第一行1个数，第n行有n个数
    转换成计算机计数方式：第n行从0到n。n从0开始。
 */
